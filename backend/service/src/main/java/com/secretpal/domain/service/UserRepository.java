package com.secretpal.domain.service;

import com.secretpal.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

  void createUser(User user, String password);

  Optional<User> findByMail(String mail);

  List<User> allUsers();
}
