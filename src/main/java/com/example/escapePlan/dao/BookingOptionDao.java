package com.example.escapePlan.dao;

import com.example.escapePlan.dto.userBookingDto.BookingDto;
import com.example.escapePlan.model.Booking;
import com.example.escapePlan.repository.BookingRepository;
import com.example.escapePlan.repository.PlanRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookingOptionDao {
    BookingRepository bookingRepository;
    PlanRepository planRepository;

    public BookingOptionDao(BookingRepository bookingRepository, PlanRepository planRepository) {
        this.bookingRepository = bookingRepository;
        this.planRepository = planRepository;
    }

    @Transactional
    public Booking addOption(BookingDto dto) {
        Booking option = new Booking();
        option.copyFromDto(dto,planRepository.findById(dto.getPlan_id()).orElseThrow());
        return bookingRepository.save(option);
    }

    public Booking showOption(Long id) {
        return bookingRepository.findById(id).orElseThrow();
    }

    public List<Booking> showAllOptions() {
        return bookingRepository.findAll();
    }

    @Transactional
    public Booking updateOption(Long id, BookingDto dto) {
        Booking existingOption = bookingRepository.findById(id).orElseThrow();
        existingOption.copyFromDto(dto,planRepository.findById(dto.getPlan_id()).orElseThrow());
        return bookingRepository.save(existingOption);
    }

    @Transactional
    public void deleteOption(Long id) {
        bookingRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllOptions() {
        bookingRepository.deleteAll();
    }

}
