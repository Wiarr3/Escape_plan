package com.example.escapePlan.api.user;

import com.example.escapePlan.dto.BookingOptionDto;
import com.example.escapePlan.dto.userBookingDto.*;
import com.example.escapePlan.service.customer.UserBookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/booking")
public class UserBookingController {

    private final UserBookingService userBookingService;

    public UserBookingController(UserBookingService userBookingService){
        this.userBookingService = userBookingService;
    }

    @GetMapping("/show")
    public BookingOptionDto showBooking(@RequestBody ShowOptionDto id){
        return userBookingService.showOption(id.getId());
    }

    @GetMapping("/show/all")
    public List<BookingOptionDto> showAllOptions(@RequestBody Long planId){
        return userBookingService.showAllOptions(planId);
    }

    @PostMapping("/add")
    public BookingOptionDto addBooking(@RequestBody BookingOptionDto dto){
        return userBookingService.addOption(dto);
    }

    @PatchMapping("/price")
    public UpdatePriceDto changePrice(@RequestBody UpdatePriceDto updatePriceDto){
        return userBookingService.updatePrice(updatePriceDto);
    }
    @PatchMapping("/address")
    public UpdateAddressDto changeAddress(@RequestBody UpdateAddressDto updateAddressDto){
        return userBookingService.updateAddress(updateAddressDto);
    }
    @PatchMapping("/status")
    public UpdateStatusDto changeStatus(@RequestBody UpdateStatusDto updateStatusDto){
        return userBookingService.updateStatus(updateStatusDto);
    }

    @PatchMapping("/weather")
    public UpdateWeatherDto changeWeather(@RequestBody UpdateWeatherDto updateWeatherDto){
        return userBookingService.updateWeather(updateWeatherDto);
    }

    @PatchMapping("/contact")
    public UpdateContactDto changeContact(@RequestBody UpdateContactDto updateContactDto){
        return userBookingService.updateContact(updateContactDto);
    }

    @DeleteMapping("/delete")
    public void deleteOption(@RequestBody DeleteOptionDto id){
        userBookingService.deleteOption(id.getId());
    }
}
