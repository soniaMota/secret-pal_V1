package com.secretpal.infrastructure.rest.config;

import com.secretpal.infrastructure.rest.UserApi;
import com.secretpal.infrastructure.rest.config.exception.DuplicatedUserExceptionMapper;
import com.secretpal.infrastructure.rest.config.exception.ValidationExceptionMapper;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

@ApplicationPath("/api")
public class Api extends Application {

  public Set<Class<?>> getClasses() {
    return Set.of(
        UserApi.class,
        ObjectMapperProvider.class,
        CorsFilter.class,
        DuplicatedUserExceptionMapper.class,
        ValidationExceptionMapper.class);
  }
}
