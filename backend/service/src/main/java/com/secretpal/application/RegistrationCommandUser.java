package com.secretpal.application;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegistrationCommandUser {
  private String mail;
  private String name;
  private int age;
  private String phone;
  private String password;
}
