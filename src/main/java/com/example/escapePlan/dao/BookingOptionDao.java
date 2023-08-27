package com.example.escapePlan.dao;

import com.example.escapePlan.dto.BookingOptionDto;
import com.example.escapePlan.model.BookingOption;
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
    public BookingOption addOption(BookingOptionDto dto) {
        BookingOption option = new BookingOption();
        option.copyFromDto(dto,planRepository.findById(dto.getPlan_id()).orElseThrow());
        return bookingRepository.save(option);
    }

    public BookingOption showOption(Long id) {
        return bookingRepository.findById(id).orElseThrow();
    }

    public List<BookingOption> showAllOptions() {
        return bookingRepository.findAll();
    }

    @Transactional
    public BookingOption updateOption(Long id, BookingOptionDto dto) {
        BookingOption existingOption = bookingRepository.findById(id).orElseThrow();
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
