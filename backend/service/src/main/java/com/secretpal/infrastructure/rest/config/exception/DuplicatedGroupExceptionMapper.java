package com.secretpal.infrastructure.rest.config.exception;

import com.secretpal.domain.exception.DuplicatedGroupName;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DuplicatedGroupExceptionMapper implements ExceptionMapper<DuplicatedGroupName> {
    @Override
    public Response toResponse(DuplicatedGroupName duplicatedGroupName) {
        return Response.status(Response.Status.CONFLICT).entity(duplicatedGroupName.getMessage()).build();
    }
}
