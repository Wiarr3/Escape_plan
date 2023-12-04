package com.example.escapePlan.service.admin;

import com.example.escapePlan.dto.userPlanDto.PlanDto;
import com.example.escapePlan.model.Plan;

import java.util.List;

public interface PlanService {
    public Plan addTrip(PlanDto dto);
    public Plan updateTrip(Long id, PlanDto dto);
    public Plan showTrip(Long id);
    public List<Plan> showAllTrips();
    public void deleteAllTrips();
    public void deleteTrip(Long id);
}
