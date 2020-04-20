package com.secretpal.infrastructure.rest;

import javax.ws.rs.Path;

import lombok.NoArgsConstructor;

@Path("groups")
@NoArgsConstructor
public class GroupApi {

    private GroupCommandService groupCommandService;
}
