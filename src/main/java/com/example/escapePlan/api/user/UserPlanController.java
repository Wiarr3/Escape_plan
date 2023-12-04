package com.example.escapePlan.api.user;

import com.example.escapePlan.dto.userBookingDto.BookingDto;
import com.example.escapePlan.dto.userBookingDto.BookingWithIdDto;
import com.example.escapePlan.dto.userPlanDto.PlanDto;
import com.example.escapePlan.dto.userPlanDto.PlanWithIdDto;
import com.example.escapePlan.service.customer.AuthenticationService;
import com.example.escapePlan.service.customer.UserBookingService;
import com.example.escapePlan.service.customer.UserPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/main")
public class UserPlanController {
    private AuthenticationService authService;
    private UserBookingService bookingService;
    private UserPlanService planService;

    public UserPlanController(AuthenticationService authService, UserBookingService bookingService, UserPlanService planService)
    {
        this.authService = authService;
        this.planService = planService;
        this.bookingService = bookingService;
    }

    @GetMapping("/plans/all")
    public List<PlanDto> listOfPlans(){
        return planService.showAllPlans(authService.getCurrentId());
    }

    @GetMapping("/booking/all")
    public List<BookingDto> showPlanOptions(@RequestBody Long planId){
        return bookingService.showAllOptions(planId);
    }

    @PostMapping("/plans/add")
    public PlanDto addTripPlan(@RequestBody PlanDto dto){
        dto.setUser_id(authService.getCurrentId());
        return planService.addPlan(dto);
    }

    @PatchMapping("/plans/update")
    public PlanWithIdDto updateTripPlan(@RequestBody PlanWithIdDto dto){
        dto.setUser_id(authService.getCurrentId());
        return planService.updatePlan(dto);
    }

    @DeleteMapping("/plans/delete/{id}")
    public void deleteTripPlan(@PathVariable Long id){
        planService.deletePlan(id);
    }

    @PostMapping("/booking/add")
    public BookingDto addOption(@RequestBody BookingDto dto){
        return bookingService.addOption(dto);
    }

    @PatchMapping("/booking/update")
    public BookingDto updateOption(@RequestBody BookingWithIdDto dto){
        return bookingService.updateOption(dto);
    }

    @DeleteMapping("/booking/delete/{id}")
    public void deleteBookingOption(@PathVariable Long id){
        bookingService.deleteOption(id);
    }


}
