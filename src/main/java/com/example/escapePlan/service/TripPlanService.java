package com.example.escapePlan.service;

import com.example.escapePlan.dto.TripPlanDto;
import com.example.escapePlan.model.TripPlan;

import java.util.List;

public interface TripPlanService {
    public TripPlan addTrip(TripPlanDto dto);
    public TripPlan updateTrip(Long id, TripPlanDto dto);
    public TripPlan showTrip(Long id);
    public List<TripPlan> showAllTrips();
    public void deleteAllTrips();
    public void deleteTrip(Long id);
}
