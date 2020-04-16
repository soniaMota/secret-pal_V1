package com.secretpal.application;

import com.secretpal.domain.exception.DuplicatedUserMail;
import com.secretpal.domain.model.User;
import com.secretpal.domain.service.UserRepository;

import javax.inject.Inject;

public class UserCommandService {

  private final UserRepository userRepository;

  @Inject
  public UserCommandService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void registerUser(RegistrationCommandUser registrationCommandUser) {
    if (isUsernameAvailable(registrationCommandUser.getMail())) {
      userRepository.createUser(User.builder()
              .mail(registrationCommandUser.getMail())
              .name(registrationCommandUser.getName())
              .phone(registrationCommandUser.getPhone()).build(),
          registrationCommandUser.getPassword());
    } else {
      throw new DuplicatedUserMail(registrationCommandUser.getMail());
    }
  }

  private boolean isUsernameAvailable(String mail) {
    return userRepository.findByMail(mail).isEmpty();
  }
}
