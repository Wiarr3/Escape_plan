package com.example.escapePlan.repository;

import com.example.escapePlan.model.BookingOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingOption, Long> {
}


