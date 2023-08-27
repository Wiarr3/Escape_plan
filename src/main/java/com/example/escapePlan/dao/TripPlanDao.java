package com.example.escapePlan.dao;

import com.example.escapePlan.dto.TripPlanDto;
import com.example.escapePlan.model.TripPlan;
import com.example.escapePlan.repository.PlanRepository;
import com.example.escapePlan.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TripPlanDao {
    PlanRepository planRepository;
    UserRepository userRepository;

    public TripPlanDao(PlanRepository planRepository, UserRepository userRepository) {
        this.planRepository = planRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public TripPlan addPlan(TripPlanDto dto) {
        TripPlan plan = new TripPlan();
        plan.copyFromDto(dto, userRepository.findById(dto.getUser_id()).orElseThrow());
        return plan;
    }

    @Transactional
    public TripPlan updatePlan(Long id, TripPlanDto updatedPlan) {
        TripPlan existingPlan = planRepository.findById(id).orElseThrow();
        existingPlan.copyFromDto(updatedPlan,userRepository.findById(updatedPlan.getUser_id()).orElseThrow());
        return planRepository.save(existingPlan);
    }

    public List<TripPlan> showAllPlans() {
        return planRepository.findAll();
    }

    public TripPlan showPlan(Long id) {
        return planRepository.findById(id).orElseThrow();
    }

    @Transactional
    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllPlans() {
        planRepository.deleteAll();
    }


}
