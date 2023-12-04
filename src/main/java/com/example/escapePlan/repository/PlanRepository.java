package com.example.escapePlan.repository;

import com.example.escapePlan.model.Plan;
import com.example.escapePlan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

    public List<Plan> findAllByUser(User user);

}


