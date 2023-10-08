package com.example.escapePlan.api.admin;

import com.example.escapePlan.dto.TripPlanDto;
import com.example.escapePlan.model.TripPlan;
import com.example.escapePlan.service.TripPlanService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripPlanController {
    private final TripPlanService service;

    public TripPlanController(TripPlanService service) {
        this.service = service;
    }
    @PostMapping
    public TripPlan addPlan(@RequestBody TripPlanDto plan){
        return service.addTrip(plan);
    }
    @PatchMapping("/{id}")
    public TripPlan updatePlan(@PathVariable Long id, @RequestBody TripPlanDto plan){
        return service.updateTrip(id,plan);
    }
    @GetMapping("/{id}")
    public TripPlan showPlan(@PathVariable Long id){
        return service.showTrip(id);
    }
    @GetMapping
    public List<TripPlan> showAllPlans(){
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
