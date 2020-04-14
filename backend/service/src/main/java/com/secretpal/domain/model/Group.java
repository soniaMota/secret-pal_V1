package com.secretpal.domain.model;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Group {
    String name;
    User userAdmin;
    List<User> users;
    List<Event> events;
}
