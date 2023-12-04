package com.example.escapePlan.api.admin;

import com.example.escapePlan.dto.userPlanDto.PlanDto;
import com.example.escapePlan.service.customer.AuthenticationService;
import com.example.escapePlan.service.customer.UserAccountService;
import com.example.escapePlan.service.customer.UserBookingService;
import com.example.escapePlan.service.customer.UserPlanService;
import com.example.escapePlan.utills.PlanStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private final AuthenticationService authService;
    private final UserAccountService accountService;
    private final UserBookingService bookingService;
    private final UserPlanService planService;

    public TestController(AuthenticationService authService, UserAccountService accountService, UserBookingService bookingService, UserPlanService planService) {
        this.accountService = accountService;
        this.authService = authService;
        this.bookingService = bookingService;
        this.planService = planService;
    }

    public void createTestData(){
        authService.registerUser("example@email.com","testUser2","123");
        Long id = authService.getIdByUsername("testUser2");
        planService.addPlan(new PlanDto(PlanStatus.PLANNING,"Plan1","Opis1","Adres1","daty1",id));
        planService.addPlan(new PlanDto(PlanStatus.PLANNING,"Plan2","Opis2","Adres2","daty2",id));
        planService.addPlan(new PlanDto(PlanStatus.PLANNING,"Plan3","Opis3","Adres3","daty3",id));
    }


}
