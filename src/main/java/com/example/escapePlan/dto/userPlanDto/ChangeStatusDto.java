package com.example.escapePlan.dto.userPlanDto;

import com.example.escapePlan.utills.PlanStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChangeStatusDto {
    private PlanStatus status;
    private Long id;
}
