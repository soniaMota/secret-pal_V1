package com.secretpal.application;

import com.secretpal.domain.exception.DuplicatedEventName;
import com.secretpal.domain.model.Event;
import com.secretpal.domain.service.EventRepository;

import javax.inject.Inject;

public class EventCommandService {

    private final EventRepository eventRepository;

    @Inject
    public EventCommandService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public void addEvent(RegistrationCommandEvent registrationCommandEvent){
        if(isEventNameAvailable(registrationCommandEvent.getName())){
            eventRepository.createEvent(Event.builder()
                    .name(registrationCommandEvent.getName())
                    .dateTime(registrationCommandEvent.getDateTime())
                    .budget(registrationCommandEvent.getBudget())
                    .childrenBudget(registrationCommandEvent.getChildrenBudget())
                    .place(registrationCommandEvent.getPlace())
                    .raffled_of(registrationCommandEvent.isRaffled_of())
                    .group(registrationCommandEvent.getGroup())
                    .build());
        }else {
            throw new DuplicatedEventName(registrationCommandEvent.getName());
        }
    }

    private boolean isEventNameAvailable(String name) {
        return eventRepository.findByNameEvent(name).isEmpty();
    }

}
