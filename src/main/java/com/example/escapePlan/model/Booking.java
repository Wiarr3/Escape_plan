package com.example.escapePlan.model;

import com.example.escapePlan.dto.userBookingDto.BookingDto;
import com.example.escapePlan.dto.userBookingDto.BookingWithIdDto;
import com.example.escapePlan.utills.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "booking_option")
@NoArgsConstructor
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookingStatus status;
    @Column(name = "address")
    private String address;
    @Column(name = "date")
    private String date;
    @Column(name = "weather")
    private String weather;
    @Column(name = "price")
    private int price;
    @Column(name = "contact")
    private String contact;
    @ManyToOne
    @JoinColumn(name = "trip_plan")
    private Plan plan;

    public void copyFromDto(BookingDto dto, Plan plan) {
        setContact(dto.getContact());
        setWeather(dto.getWeather());
        setAddress(dto.getAddress());
        setDate(dto.getDate());
        setPrice(dto.getPrice());
        setStatus(dto.getStatus());
        setPlan(plan);
    }
    public void copyFromDto(BookingWithIdDto dto, Plan plan) {
        setContact(dto.getContact());
        setWeather(dto.getWeather());
        setAddress(dto.getAddress());
        setDate(dto.getDate());
        setPrice(dto.getPrice());
        setStatus(dto.getStatus());
        setPlan(plan);
    }

    public BookingDto createDto() {
        return new BookingDto(status, address, date, weather, price, contact, plan.getId());
    }

    public BookingWithIdDto createDtoWithId() {
        return new BookingWithIdDto(id,status, address, date, weather, price, contact, plan.getId());
    }
}
