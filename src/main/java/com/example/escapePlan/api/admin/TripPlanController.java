package com.example.escapePlan.api.admin;

import com.example.escapePlan.dto.userPlanDto.PlanDto;
import com.example.escapePlan.model.Plan;
import com.example.escapePlan.service.admin.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripPlanController {
    private final PlanService service;

    public TripPlanController(PlanService service) {
        this.service = service;
    }
    @PostMapping
    public Plan addPlan(@RequestBody PlanDto plan){
        return service.addTrip(plan);
    }
    @PatchMapping("/{id}")
    public Plan updatePlan(@PathVariable Long id, @RequestBody PlanDto plan){
        return service.updateTrip(id,plan);
    }
    @GetMapping("/{id}")
    public Plan showPlan(@PathVariable Long id){
        return service.showTrip(id);
    }
    @GetMapping
    public List<Plan> showAllPlans(){
        return service.showAllTrips();
    }
    @DeleteMapping("/{id}")
    public void deletePlan(@PathVariable Long id){
        service.deleteTrip(id);
    }
    @DeleteMapping
    public void deleteAllPlans(){
        service.deleteAllTrips();
    }
}
