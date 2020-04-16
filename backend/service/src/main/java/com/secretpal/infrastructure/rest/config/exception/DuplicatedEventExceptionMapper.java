package com.secretpal.infrastructure.rest.config.exception;

import com.secretpal.domain.exception.DuplicatedEventName;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DuplicatedEventExceptionMapper implements ExceptionMapper<DuplicatedEventName> {

    @Override
    public Response toResponse(DuplicatedEventName duplicatedEventName) {
        return Response.status(Response.Status.CONFLICT).entity(duplicatedEventName.getMessage()).build();
    }
}
