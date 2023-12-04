package com.example.escapePlan.repository;

import com.example.escapePlan.model.Booking;
import com.example.escapePlan.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    public List<Booking> findAllByTripPlan(Plan plan);
}


