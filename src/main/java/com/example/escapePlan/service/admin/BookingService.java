package com.example.escapePlan.service.admin;

import com.example.escapePlan.dto.userBookingDto.BookingDto;
import com.example.escapePlan.model.Booking;

import java.util.List;

public interface BookingService {
    public Booking addOption(BookingDto dto);
    public Booking updateOption(Long id, BookingDto dto);
    public List<Booking> showAllOptions();
    public Booking showOption(Long id);
    public void deleteOption(Long id);
    public void deleteAllOptions();

}
