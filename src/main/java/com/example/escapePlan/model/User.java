package com.example.escapePlan.model;

import com.example.escapePlan.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    /*
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Address> addresses;

     */

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<TripPlan> tripPlans;

    public User(String name, String surname, String email, String password) {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public void copyFromDto(UserDto dto){
        setPassword(dto.getPassword());
        setEmail(dto.getEmail());
        setName(dto.getName());
        setSurname(dto.getSurname());
        setAddress(dto.getAddress());
    }
}
