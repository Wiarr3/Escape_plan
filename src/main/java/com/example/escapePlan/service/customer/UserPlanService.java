package com.example.escapePlan.service.customer;

import com.example.escapePlan.dto.userPlanDto.TripPlanDto;
import com.example.escapePlan.model.TripPlan;
import com.example.escapePlan.repository.PlanRepository;
import com.example.escapePlan.repository.UserRepository;
import com.example.escapePlan.utills.PlanStatus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserPlanService {

    public PlanRepository planRepository;
    public UserRepository userRepository;

    public UserPlanService(PlanRepository planRepository, UserRepository userRepository){
        this.planRepository = planRepository;
        this.userRepository = userRepository;
    }

    public TripPlanDto showPlan(Long id){
        TripPlan tripPlan = planRepository.findById(id).orElseThrow();
        return tripPlan.createDto();
    }

    public List<TripPlanDto> showAllPlans(Long id){
        List<TripPlan> tripPlan = planRepository.findAllByUser(userRepository.findById(id).orElseThrow());
        return tripPlan.stream().map(TripPlan::createDto).toList();
    }

    public TripPlanDto addPlan(Long id, TripPlanDto tripPlanDto){
        TripPlan tripPlan = new TripPlan();
        tripPlan.copyFromDto(tripPlanDto, userRepository.findById(id).orElseThrow());
        planRepository.save(tripPlan);
        return tripPlanDto;
    }

    public String updateDesc(Long id, String desc){
        TripPlan tripPlan = planRepository.findById(id).orElseThrow();
        tripPlan.setDescription(desc);
        planRepository.save(tripPlan);
        return desc;
    }

    public String updateName(Long id, String name){
        TripPlan tripPlan = planRepository.findById(id).orElseThrow();
        tripPlan.setName(name);
        planRepository.save(tripPlan);
        return name;
    }

    public PlanStatus updateStatus(Long id, PlanStatus status){
        TripPlan tripPlan = planRepository.findById(id).orElseThrow();
        tripPlan.setStatus(status);
        planRepository.save(tripPlan);
        return status;
    }

    public void deletePlan(Long id){
        planRepository.deleteById(id);
    }
}
