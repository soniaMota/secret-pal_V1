package com.secretpal.infrastructure.rest.config.exception;

import com.secretpal.domain.exception.DuplicatedUserMail;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DuplicatedUserExceptionMapper implements ExceptionMapper<DuplicatedUserMail> {
    @Override
    public Response toResponse(DuplicatedUserMail duplicatedUserMail) {
        return Response.status(Response.Status.CONFLICT).entity(duplicatedUserMail.getMessage()).build();
    }
}
