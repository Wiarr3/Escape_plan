package com.example.escapePlan.service.customer;


import com.example.escapePlan.dto.BookingOptionDto;
import com.example.escapePlan.dto.userBookingDto.*;
import com.example.escapePlan.model.BookingOption;
import com.example.escapePlan.model.TripPlan;
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

    public BookingOptionDto showOption(Long id){
        BookingOption option = bookingRepository.findById(id).orElseThrow();
        return option.createDto();
    }

    public List<BookingOptionDto> showAllOptions(Long planId){
        TripPlan plan = planRepository.findById(planId).orElseThrow();
        List<BookingOption> options = bookingRepository.findAllByTripPlan(plan);
        return options.stream().map(BookingOption::createDto).toList();

    }

    public BookingOptionDto addOption(BookingOptionDto dto){
        TripPlan plan = planRepository.findById(dto.getPlan_id()).orElseThrow();
        BookingOption option = new BookingOption();
        option.copyFromDto(dto,plan);
        bookingRepository.save(option);
        return option.createDto();
    }

    public UpdatePriceDto updatePrice(UpdatePriceDto updatePriceDto){
        BookingOption option = bookingRepository.findById(updatePriceDto.getId()).orElseThrow();
        option.setPrice(updatePriceDto.getPrice());
        bookingRepository.save(option);
        return updatePriceDto;
    }

    public UpdateWeatherDto updateWeather(UpdateWeatherDto updateWeatherDto){
        BookingOption option = bookingRepository.findById(updateWeatherDto.getId()).orElseThrow();
        option.setWeather(updateWeatherDto.getWeather());
        bookingRepository.save(option);
        return updateWeatherDto;
    }

    public UpdateAddressDto updateAddress(UpdateAddressDto updateAddressDto){
        BookingOption option = bookingRepository.findById(updateAddressDto.getId()).orElseThrow();
        option.setAddress(updateAddressDto.getAddress());
        bookingRepository.save(option);
        return updateAddressDto;
    }

    public UpdateStatusDto updateStatus(UpdateStatusDto updateStatusDto){
        BookingOption option = bookingRepository.findById(updateStatusDto.getId()).orElseThrow();
        option.setStatus(updateStatusDto.getStatus());
        bookingRepository.save(option);
        return updateStatusDto;
    }

    public UpdateContactDto updateContact(UpdateContactDto updateContactDto){
        BookingOption option = bookingRepository.findById(updateContactDto.getId()).orElseThrow();
        option.setContact(updateContactDto.getContact());
        bookingRepository.save(option);
        return updateContactDto;
    }

    public void deleteOption(Long id){
        bookingRepository.deleteById(id);
    }
}
