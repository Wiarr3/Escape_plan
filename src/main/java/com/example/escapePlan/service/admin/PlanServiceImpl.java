package com.example.escapePlan.service.admin;

import com.example.escapePlan.dao.TripPlanDao;
import com.example.escapePlan.dto.userPlanDto.PlanDto;
import com.example.escapePlan.model.Plan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanServiceImpl implements PlanService {
    private final TripPlanDao tripPlanDao;
    public PlanServiceImpl(TripPlanDao tripPlanDao){
        this.tripPlanDao = tripPlanDao;
    }

    @Override
    public Plan addTrip(PlanDto dto) {
        return tripPlanDao.addPlan(dto);
    }

    @Override
    public Plan updateTrip(Long id, PlanDto dto) {
        return tripPlanDao.updatePlan(id,dto);
    }

    @Override
    public Plan showTrip(Long id) {
        return tripPlanDao.showPlan(id);
    }

    @Override
    public List<Plan> showAllTrips() {
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
