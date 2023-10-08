package com.example.escapePlan.dto.userBookingDto;

import com.example.escapePlan.utills.OptionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateStatusDto {
    private OptionStatus status;
    private Long id;
}
