package com.example.escapePlan.dto.userAccountDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateEmailDto {
    private String password;
    private String newEmail;
}
