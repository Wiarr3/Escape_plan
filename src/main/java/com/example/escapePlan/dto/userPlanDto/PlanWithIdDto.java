package com.example.escapePlan.dto.userPlanDto;

import com.example.escapePlan.utills.PlanStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanWithIdDto {
    private Long id;
    private PlanStatus status;
    private String name;
    private String description;
    private String address;
    private String dates;
    private Long user_id;
}