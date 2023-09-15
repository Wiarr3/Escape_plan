package com.example.escapePlan.dto;

import com.example.escapePlan.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private UserDto userDto;
    private String jwt;

    public LoginResponseDto(User user, String jwt){
        userDto = new UserDto(user.getEmail(),user.getUsername(),user.getPassword(),user.getAddress());
        this.jwt = jwt;
    }

}
