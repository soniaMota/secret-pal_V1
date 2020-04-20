package com.secretpal.infrastructure.rest.config;

import com.secretpal.infrastructure.rest.GroupApi;
import com.secretpal.infrastructure.rest.UserApi;
import com.secretpal.infrastructure.rest.config.exception.DuplicatedGroupExceptionMapper;
import com.secretpal.infrastructure.rest.config.exception.DuplicatedUserExceptionMapper;
import com.secretpal.infrastructure.rest.config.exception.ValidationExceptionMapper;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class Api extends Application {

  public Set<Class<?>> getClasses() {
    return Set.of(
        UserApi.class,
            GroupApi.class,
        ObjectMapperProvider.class,
        CorsFilter.class,
        DuplicatedUserExceptionMapper.class,
            DuplicatedGroupExceptionMapper.class,
        ValidationExceptionMapper.class);
  }
}
