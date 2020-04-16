package com.secretpal.infrastructure.rest;

import com.secretpal.application.GroupCommandService;
import com.secretpal.application.RegistrationCommandGroup;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import lombok.NoArgsConstructor;

@Path("groups")
@NoArgsConstructor
public class GroupApi {

    private GroupCommandService groupCommandService;

    @Inject
    public GroupApi(GroupCommandService groupCommandService){
        this.groupCommandService = groupCommandService;
    }

    @POST
    @Consumes("application/json")
    public Response createGroup(RegistrationCommandGroup registrationCommandGroup){
        this.groupCommandService.addGroup(registrationCommandGroup);
        return Response.ok().build();
    }
}
