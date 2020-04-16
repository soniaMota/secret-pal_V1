package com.secretpal.application;

import com.secretpal.domain.model.Event;
import com.secretpal.domain.model.User;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationCommandGroup {
    private String name;
    private User userAdmin;
    private List<User> users;
    private List<Event> events;
}
