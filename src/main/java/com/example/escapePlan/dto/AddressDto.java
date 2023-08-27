package com.example.escapePlan.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AddressDto {
    private Long userId;
    private String town;
    private String street;
    private Integer houseNumber;
    private String postcode;
}
