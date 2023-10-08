package com.example.escapePlan.api.user;

import com.example.escapePlan.dto.TripPlanDto;
import com.example.escapePlan.dto.userPlanDto.ChangeDesc;
import com.example.escapePlan.dto.userPlanDto.ChangeNameDto;
import com.example.escapePlan.dto.userPlanDto.ChangeStatusDto;
import com.example.escapePlan.service.AuthenticationService;
import com.example.escapePlan.service.customer.UserPlanService;
import com.example.escapePlan.utills.PlanStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/plan")
public class UserTripPlanController {
    public AuthenticationService authService;
    public UserPlanService planService;

    public UserTripPlanController(AuthenticationService authService, UserPlanService planService){
        this.authService = authService;
        this.planService = planService;
    }

    @PostMapping("/add")
    public TripPlanDto addTripPlan(@RequestBody TripPlanDto dto){
        return planService.addPlan(authService.getCurrentId(),dto);
    }

    @PatchMapping("/desc")
    public String changeDesc(@RequestBody ChangeDesc changeDesc){
        return planService.updateDesc(changeDesc.getId(),changeDesc.getDesc());
    }

    @PatchMapping("/name")
    public String changeName(@RequestBody ChangeNameDto changeNameDto){
        return planService.updateName(changeNameDto.getId(),changeNameDto.getName());
    }

    @PatchMapping("/status")
    public PlanStatus changeStatus(@RequestBody ChangeStatusDto changeStatusDto){
        return planService.updateStatus(changeStatusDto.getId(),changeStatusDto.getStatus());
    }

    @DeleteMapping("/delete")
    public void deleteTripPlan(@RequestBody Long id){
        planService.deletePlan(id);
    }
}
