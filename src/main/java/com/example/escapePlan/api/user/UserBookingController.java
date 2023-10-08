package com.example.escapePlan.api.user;

import com.example.escapePlan.dto.BookingOptionDto;
import com.example.escapePlan.dto.userBookingDto.*;
import com.example.escapePlan.utills.OptionStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/booking")
public class UserBookingController {

    @GetMapping("/show")
    public BookingOptionDto showBooking(@RequestBody Long id){
        return null;
    }

    @GetMapping("/show/all")
    public List<BookingOptionDto> showAllOptions(@RequestBody Long planId){
        return null;
    }

    @PostMapping("/add")
    public BookingOptionDto addBooking(@RequestBody BookingOptionDto dto){
        return null;
    }

    @PatchMapping("/price")
    public Integer changePrice(@RequestBody ChangePrice changePrice){
        return null;
    }
    @PatchMapping("/address")
    public String changeAddress(@RequestBody ChangeAddress changeAddress){
        return null;
    }
    @PatchMapping("/status")
    public OptionStatus changeStatus(@RequestBody ChangeStatus changeStatus){
        return null;
    }

    @PatchMapping("/weather")
    public String changeWeather(@RequestBody ChangeWeather changeWeather){
        return null;
    }

    @PatchMapping("/contact")
    public String changeContact(@RequestBody ChangeContact changeContact){
        return null;
    }

    @DeleteMapping("/delete")
    public void deleteOption(@RequestBody Long id){

    }
}
