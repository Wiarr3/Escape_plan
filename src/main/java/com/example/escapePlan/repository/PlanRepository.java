package com.example.escapePlan.repository;

import com.example.escapePlan.model.TripPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<TripPlan, Long> {

}


