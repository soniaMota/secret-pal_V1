package com.secretpal.application;

import com.secretpal.domain.model.Group;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationCommandEvent {
    private String name;
    private LocalDateTime dateTime;
    private int budget;
    private int childrenBudget;
    private String place;
    private boolean raffled_of;
    private Group group;
}
