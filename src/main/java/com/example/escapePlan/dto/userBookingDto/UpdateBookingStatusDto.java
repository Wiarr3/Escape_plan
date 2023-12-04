package com.example.escapePlan.dto.userBookingDto;

import com.example.escapePlan.utills.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateBookingStatusDto {
    BookingStatus status;
    Long booking_id;
}
