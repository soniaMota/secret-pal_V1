package com.secretpal.domain.service;

import com.secretpal.domain.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository {

    void createEvent(Event event);

    Optional<Event> findByNameEvent(String name);

    List<Event> allEvents();

    List<Event> allEventsByDate();
}
