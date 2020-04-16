package com.secretpal.infrastructure.rest;

import com.secretpal.application.RegistrationCommandUser;
import com.secretpal.application.UserCommandService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import lombok.NoArgsConstructor;

@Path("users")
@NoArgsConstructor
public class UserApi {

  private UserCommandService userCommandService;

  @Inject
  public UserApi(UserCommandService userCommandService) {
    this.userCommandService = userCommandService;
  }

  @POST
  @Consumes("application/json")
  public Response registerUser(RegistrationCommandUser registrationCommandUser) {
    this.userCommandService.registerUser(registrationCommandUser);
    return Response.ok().build();
  }
}
