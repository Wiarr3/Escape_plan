package com.example.escapePlan.dto.userAccountDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChangeLoginDto {
    String password;
    String newLogin;
}
