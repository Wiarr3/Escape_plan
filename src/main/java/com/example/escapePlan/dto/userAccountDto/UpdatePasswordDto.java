package com.example.escapePlan.dto.userAccountDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdatePasswordDto {
    private String oldPassword;
    private String newPassword;
}
