package com.example.escapePlan.repository;

import com.example.escapePlan.model.BookingOption;
import com.example.escapePlan.model.TripPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingOption, Long> {
    public List<BookingOption> findAllByTripPlan(TripPlan tripPlan);
}


