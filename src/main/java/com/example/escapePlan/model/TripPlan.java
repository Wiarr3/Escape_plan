package com.example.escapePlan.model;

import com.example.escapePlan.dto.TripPlanDto;
import com.example.escapePlan.utills.PlanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "trip_plan")
@NoArgsConstructor
@Getter
@Setter
public class TripPlan {
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
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
    @OneToMany(mappedBy = "tripPlan")
    private Set<BookingOption> bookingOptions;

    public TripPlan(PlanStatus status, String name, String description, User user) {
        super();
        this.status = status;
        this.name = name;
        this.description = description;
        this.user = user;
    }

    public void copyFromDto(TripPlanDto dto, User user){
        setStatus(dto.getStatus());
        setName(dto.getName());
        setDescription(dto.getDescription());
        setUser(user);
    }

}
