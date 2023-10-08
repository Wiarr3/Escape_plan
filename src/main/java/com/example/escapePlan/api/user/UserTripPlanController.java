package com.example.escapePlan.api.user;

import com.example.escapePlan.dto.userPlanDto.*;
import com.example.escapePlan.service.AuthenticationService;
import com.example.escapePlan.service.customer.UserPlanService;
import com.example.escapePlan.utills.PlanStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/plan")
public class UserTripPlanController {
    public AuthenticationService authService;
    public UserPlanService planService;

    public UserTripPlanController(AuthenticationService authService, UserPlanService planService){
        this.authService = authService;
        this.planService = planService;
    }

    @GetMapping("/show/{id}")
    public TripPlanDto showTripPlan(@PathVariable Long id){
        return planService.showPlan(id);
    }

    @GetMapping("/show/all")
    public List<TripPlanDto> showAllTripPlans(){
        return planService.showAllPlans(authService.getCurrentId());
    }

    @PostMapping("/add")
    public TripPlanDto addTripPlan(@RequestBody TripPlanDto dto){
        return planService.addPlan(authService.getCurrentId(),dto);
    }

    @PatchMapping("/desc")
    public String changeDesc(@RequestBody UpdateDescDto updateDescDto){
        return planService.updateDesc(updateDescDto.getId(), updateDescDto.getDesc());
    }

    @PatchMapping("/name")
    public String changeName(@RequestBody UpdateNameDto updateNameDto){
        return planService.updateName(updateNameDto.getId(), updateNameDto.getName());
    }

    @PatchMapping("/status")
    public PlanStatus changeStatus(@RequestBody UpdateStatusDto updateStatusDto){
        return planService.updateStatus(updateStatusDto.getId(), updateStatusDto.getStatus());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTripPlan(@PathVariable Long id){
        planService.deletePlan(id);
    }
}
