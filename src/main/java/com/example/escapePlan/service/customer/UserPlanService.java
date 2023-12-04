package com.example.escapePlan.service.customer;

import com.example.escapePlan.dto.userPlanDto.PlanDto;
import com.example.escapePlan.dto.userPlanDto.PlanWithIdDto;
import com.example.escapePlan.model.Plan;
import com.example.escapePlan.repository.PlanRepository;
import com.example.escapePlan.repository.UserRepository;
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

    public PlanDto showPlan(Long id){
        Plan plan = planRepository.findById(id).orElseThrow();
        return plan.createDto();
    }

    public List<PlanDto> showAllPlans(Long id){
        List<Plan> plan = planRepository.findAllByUser(userRepository.findById(id).orElseThrow());
        return plan.stream().map(Plan::createDto).toList();
    }

    public PlanDto addPlan(PlanDto dto){
        Plan plan = new Plan();
        plan.copyFromDto(dto, userRepository.findById(dto.getUser_id()).orElseThrow());
        planRepository.save(plan);
        return dto;
    }

    public PlanWithIdDto updatePlan(PlanWithIdDto dto){
        Plan plan = planRepository.findById(dto.getId()).orElseThrow();
        plan.copyFromDto(dto, userRepository.findById(dto.getUser_id()).orElseThrow());
        planRepository.save(plan);
        return dto;
    }

    public void deletePlan(Long id){
        planRepository.deleteById(id);
    }
}
