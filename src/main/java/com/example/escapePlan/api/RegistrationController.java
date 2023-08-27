package com.example.escapePlan.api;

import com.example.escapePlan.dto.UserDto;
import com.example.escapePlan.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
            this.userService = userService;
    }
    @GetMapping("/form")
    public String showRegistration()
    {
        return "registration";
    }
    /*
    public String registerAccount(@ModelAttribute("user") UserDto registrationDto){
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }

     */
}