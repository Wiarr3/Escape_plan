package com.example.escapePlan.api.user;

import com.example.escapePlan.dto.LoginResponseDto;
import com.example.escapePlan.dto.userAccountDto.UserDto;
import com.example.escapePlan.model.User;
import com.example.escapePlan.service.customer.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService){
        this.authService = authService;
    }
    @PostMapping("/register")
    public User registerUser(@RequestBody UserDto userDto){
        return authService.registerUser(userDto.getEmail(),userDto.getUsername(), userDto.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDto loginUser(@RequestBody UserDto userDto){
        return authService.loginUser(userDto.getUsername(),userDto.getPassword());
    }
}
