package com.secretpal.domain.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Event {
    String name;
    LocalDateTime date;
    int budget;
    int childrenBudget;
    String place;
    boolean raffled_of;
    Group group;
}
