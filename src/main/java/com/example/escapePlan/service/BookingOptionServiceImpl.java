package com.example.escapePlan.service;

import com.example.escapePlan.dao.BookingOptionDao;
import com.example.escapePlan.dto.BookingOptionDto;
import com.example.escapePlan.model.BookingOption;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingOptionServiceImpl implements BookingOptionService{
    private final BookingOptionDao bookingOptionDao;

    public BookingOptionServiceImpl(BookingOptionDao bookingOptionDao){
        this.bookingOptionDao = bookingOptionDao;
    }
    @Override
    public BookingOption addOption(BookingOptionDto dto) {
        return bookingOptionDao.addOption(dto);
    }

    @Override
    public BookingOption updateOption(Long id, BookingOptionDto dto) {
        return bookingOptionDao.updateOption(id,dto);
    }

    @Override
    public List<BookingOption> showAllOptions() {
        return bookingOptionDao.showAllOptions();
    }

    @Override
    public BookingOption showOption(Long id) {
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
