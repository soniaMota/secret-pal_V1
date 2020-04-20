package com.secretpal.infrastructure.rest;

import com.secretpal.application.RaffleCommandService;
import com.secretpal.application.RegistrationCommandRaffle;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import lombok.NoArgsConstructor;

@Path("raffle")
@NoArgsConstructor
public class RaffleApi {

    private RaffleCommandService raffleCommandService;

    @Inject
    public RaffleApi(RaffleCommandService raffleCommandService) {
        this.raffleCommandService = raffleCommandService;
    }

    @POST
    @Consumes("application/json")
    public Response registerRaffle(RegistrationCommandRaffle registrationCommandRaffle) {
        if
    }
}
