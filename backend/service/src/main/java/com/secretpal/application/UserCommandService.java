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

  public void registerUser(RegistrationCommand registrationCommand) {
    if (isUsernameAvailable(registrationCommand.getMail())) {
      userRepository.createUser(User.builder()
              .mail(registrationCommand.getMail())
              .name(registrationCommand.getName())
              .phone(registrationCommand.getPhone()).build(),
          registrationCommand.getPassword());
    } else {
      throw new DuplicatedUserMail(registrationCommand.getMail());
    }
  }

  private boolean isUsernameAvailable(String mail) {
    return userRepository.findByMail(mail).isEmpty();
  }
}
