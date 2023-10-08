package com.example.escapePlan.service;

import com.example.escapePlan.dao.TripPlanDao;
import com.example.escapePlan.dto.userPlanDto.TripPlanDto;
import com.example.escapePlan.model.TripPlan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TripPlanServiceImpl implements TripPlanService{
    private final TripPlanDao tripPlanDao;
    public TripPlanServiceImpl(TripPlanDao tripPlanDao){
        this.tripPlanDao = tripPlanDao;
    }

    @Override
    public TripPlan addTrip(TripPlanDto dto) {
        return tripPlanDao.addPlan(dto);
    }

    @Override
    public TripPlan updateTrip(Long id, TripPlanDto dto) {
        return tripPlanDao.updatePlan(id,dto);
    }

    @Override
    public TripPlan showTrip(Long id) {
        return tripPlanDao.showPlan(id);
    }

    @Override
    public List<TripPlan> showAllTrips() {
        return tripPlanDao.showAllPlans();
    }

    @Override
    public void deleteAllTrips() {
        tripPlanDao.deleteAllPlans();
    }

    @Override
    public void deleteTrip(Long id) {
        tripPlanDao.deletePlan(id);
    }
}
