package com.secretpal.domain.model;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Value
@Builder
public class User {
  String mail;
  String name;
  int age;
  String phone;
}

