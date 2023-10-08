package com.example.escapePlan.repository;

import com.example.escapePlan.model.TripPlan;
import com.example.escapePlan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanRepository extends JpaRepository<TripPlan, Long> {

    public List<TripPlan> findAllByUser(User user);

}


