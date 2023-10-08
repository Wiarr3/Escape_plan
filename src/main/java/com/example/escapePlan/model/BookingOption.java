package com.example.escapePlan.model;

import com.example.escapePlan.dto.BookingOptionDto;
import com.example.escapePlan.utills.OptionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "booking_option")
@NoArgsConstructor
@Getter
@Setter
public class BookingOption {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OptionStatus status;
    @Column(name = "address")
    private String address;
    @Column(name = "weather")
    private String weather;
    @Column(name = "price")
    private int price;
    @Column(name = "contact")
    private String contact;
    @ManyToOne
    @JoinColumn(name = "trip_plan")
    private TripPlan tripPlan;

    public void copyFromDto(BookingOptionDto dto, TripPlan plan){
        setContact(dto.getContact());
        setWeather(dto.getWeather());
        setAddress(dto.getAddress());
        setPrice(dto.getPrice());
        setStatus(dto.getStatus());
        setTripPlan(plan);
    }
    public BookingOptionDto createDto(){
        return new BookingOptionDto(status,address,weather,price,contact,tripPlan.getId());
    }
}
