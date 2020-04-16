package com.secretpal.infrastructure.rest;

import com.secretpal.application.EventCommandService;
import com.secretpal.application.RegistrationCommandEvent;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import lombok.NoArgsConstructor;

@Path("events")
@NoArgsConstructor
public class EventApi {

    private EventCommandService eventCommandService;

    @Inject
    public EventApi(EventCommandService eventCommandService){
        this.eventCommandService = eventCommandService;
    }

    @POST
    @Consumes("application/json")
    public Response createEvent(RegistrationCommandEvent registrationCommandEvent){
        this.eventCommandService.addEvent(registrationCommandEvent);
        return Response.ok().build();
    }
}
