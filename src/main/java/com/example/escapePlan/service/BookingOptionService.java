package com.example.escapePlan.service;

import com.example.escapePlan.dto.BookingOptionDto;
import com.example.escapePlan.model.BookingOption;

import java.util.List;

public interface BookingOptionService {
    public BookingOption addOption(BookingOptionDto dto);
    public BookingOption updateOption(Long id, BookingOptionDto dto);
    public List<BookingOption> showAllOptions();
    public BookingOption showOption(Long id);
    public void deleteOption(Long id);
    public void deleteAllOptions();

}
