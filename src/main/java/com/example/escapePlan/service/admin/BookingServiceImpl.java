package com.example.escapePlan.service.admin;

import com.example.escapePlan.dao.BookingOptionDao;
import com.example.escapePlan.dto.userBookingDto.BookingDto;
import com.example.escapePlan.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingServiceImpl implements BookingService {
    private final BookingOptionDao bookingOptionDao;

    public BookingServiceImpl(BookingOptionDao bookingOptionDao){
        this.bookingOptionDao = bookingOptionDao;
    }
    @Override
    public Booking addOption(BookingDto dto) {
        return bookingOptionDao.addOption(dto);
    }

    @Override
    public Booking updateOption(Long id, BookingDto dto) {
        return bookingOptionDao.updateOption(id,dto);
    }

    @Override
    public List<Booking> showAllOptions() {
        return bookingOptionDao.showAllOptions();
    }

    @Override
    public Booking showOption(Long id) {
        return bookingOptionDao.showOption(id);
    }

    @Override
    public void deleteOption(Long id) {
        bookingOptionDao.deleteOption(id);
    }

    @Override
    public void deleteAllOptions() {
        bookingOptionDao.deleteAllOptions();
    }
}
