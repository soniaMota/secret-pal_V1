package com.secretpal.domain.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Raffle {
    User user1;
    User user2;
    Event event;
}
