package com.example.escapePlan.dto;

import com.example.escapePlan.utills.OptionStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingOptionDto {

    private OptionStatus status;

    private String address;

    private String weather;

    private int price;

    private String contact;

    private Long plan_id;
}
