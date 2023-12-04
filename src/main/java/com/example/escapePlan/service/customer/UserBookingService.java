package com.example.escapePlan.service.customer;


import com.example.escapePlan.dto.userBookingDto.BookingDto;
import com.example.escapePlan.dto.userBookingDto.*;
import com.example.escapePlan.model.Booking;
import com.example.escapePlan.model.Plan;
import com.example.escapePlan.repository.BookingRepository;
import com.example.escapePlan.repository.PlanRepository;
import com.example.escapePlan.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public BookingDto showOption(Long id){
        Booking option = bookingRepository.findById(id).orElseThrow();
        return option.createDto();
    }

    public List<BookingDto> showAllOptions(Long planId){
        Plan plan = planRepository.findById(planId).orElseThrow();
        List<Booking> options = bookingRepository.findAllByTripPlan(plan);
        return options.stream().map(Booking::createDto).toList();

    }

    public BookingDto addOption(BookingDto dto){
        Plan plan = planRepository.findById(dto.getPlan_id()).orElseThrow();
        Booking option = new Booking();
        option.copyFromDto(dto,plan);
        bookingRepository.save(option);
        return option.createDto();
    }

    public BookingDto updateOption(BookingWithIdDto dto){
        Booking option = bookingRepository.findById(dto.getId()).orElseThrow();
        option.copyFromDto(dto,planRepository.findById(dto.getPlan_id()).orElseThrow());
        bookingRepository.save(option);
        return option.createDto();
    }


    public void deleteOption(Long id){
        bookingRepository.deleteById(id);
    }
}
