package com.example.escapePlan.api;

import com.example.escapePlan.dto.BookingOptionDto;
import com.example.escapePlan.model.BookingOption;
import com.example.escapePlan.service.BookingOptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingOptionService service;

    public BookingController(BookingOptionService service){
        this.service = service;
    }
    @PostMapping
    public BookingOption addOption(@RequestBody BookingOptionDto optionDto){
        return service.addOption(optionDto);
    }
    @PatchMapping("/{id}")
    public BookingOption updateOption(@PathVariable Long id, @RequestBody BookingOptionDto optionDto){
        return service.updateOption(id, optionDto);
    }
    @GetMapping("/{id}")
    public BookingOption showOption(@PathVariable Long id){
        return service.showOption(id);
    }
    @GetMapping
    public List<BookingOption> showAllOptions(){
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
