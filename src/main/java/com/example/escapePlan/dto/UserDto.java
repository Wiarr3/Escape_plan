package com.example.escapePlan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class UserDto {

    private String email;
    private String username;
    private String password;
    private String address;
}
