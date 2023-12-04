package com.example.escapePlan.dto.userBookingDto;

import com.example.escapePlan.utills.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class BookingWithIdDto {

    private Long id;

    private BookingStatus status;

    private String address;

    private String date;

    private String weather;

    private int price;

    private String contact;

    private Long plan_id;
}