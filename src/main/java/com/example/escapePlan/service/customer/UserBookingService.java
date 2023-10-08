package com.example.escapePlan.service.customer;


import com.example.escapePlan.repository.BookingRepository;
import com.example.escapePlan.repository.PlanRepository;
import com.example.escapePlan.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserBookingService {
    public BookingRepository bookingRepository;
    public UserRepository userRepository;
    public PlanRepository planRepository;

    public UserBookingService(BookingRepository bookingRepository, UserRepository userRepository, PlanRepository planRepository) {
        this.bookingRepository = bookingRepository;
        this.planRepository = planRepository;
        this.userRepository = userRepository;

    }
}
