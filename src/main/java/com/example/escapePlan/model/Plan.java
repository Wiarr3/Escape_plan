package com.example.escapePlan.model;

import com.example.escapePlan.dto.userPlanDto.PlanDto;
import com.example.escapePlan.dto.userPlanDto.PlanWithIdDto;
import com.example.escapePlan.utills.PlanStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "trip_plan")
@NoArgsConstructor
@Getter
@Setter
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PlanStatus status;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "address")
    private String startingAddress;
    @Column(name = "dates")
    private String dates;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    @OneToMany(mappedBy = "tripPlan")
    private Set<Booking> bookings;

    public Plan(PlanStatus status, String name, String description, String startingAddress, String dates, User user) {
        super();
        this.status = status;
        this.name = name;
        this.description = description;
        this.startingAddress = startingAddress;
        this.dates = dates;
        this.user = user;
    }

    public void copyFromDto(PlanDto dto, User user) {
        setStatus(dto.getStatus());
        setName(dto.getName());
        setDescription(dto.getDescription());
        setUser(user);
    }

    public void copyFromDto(PlanWithIdDto dto, User user) {
        setStatus(dto.getStatus());
        setName(dto.getName());
        setDescription(dto.getDescription());
        setUser(user);
    }

    public PlanDto createDto() {
        return new PlanDto(status, name, description, startingAddress, dates, user.getId());
    }

    public PlanWithIdDto createDtoWithId() {
        return new PlanWithIdDto(id,status, name, description, startingAddress, dates, user.getId());
    }

}
