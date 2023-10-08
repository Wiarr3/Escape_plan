package com.example.escapePlan.dto.userPlanDto;

import com.example.escapePlan.utills.PlanStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TripPlanDto {
    private PlanStatus status;
    private String name;
    private String description;
    private Long user_id;
}
