package com.example.escapePlan.api.admin;

import com.example.escapePlan.dto.userBookingDto.BookingDto;
import com.example.escapePlan.model.Booking;
import com.example.escapePlan.service.admin.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService service;

    public BookingController(BookingService service){
        this.service = service;
    }
    @PostMapping
    public Booking addOption(@RequestBody BookingDto optionDto){
        return service.addOption(optionDto);
    }
    @PatchMapping("/{id}")
    public Booking updateOption(@PathVariable Long id, @RequestBody BookingDto optionDto){
        return service.updateOption(id, optionDto);
    }
    @GetMapping("/{id}")
    public Booking showOption(@PathVariable Long id){
        return service.showOption(id);
    }
    @GetMapping
    public List<Booking> showAllOptions(){
        return service.showAllOptions();
    }
    @DeleteMapping("/{id}")
    public void deleteOption(@PathVariable Long id){
        service.deleteOption(id);
    }
    @DeleteMapping
    public void deleteAllOptions(){
        service.deleteAllOptions();
    }
}
