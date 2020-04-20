package com.secretpal.domain.service;

import com.secretpal.domain.model.Group;

import java.util.List;
import java.util.Optional;

public interface GroupRepository {

    void createGroup(Group group);

    Optional<Group> findByName(String name);

    List<Group> allGroups();

}
