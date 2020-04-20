package com.secretpal.application;

import com.secretpal.domain.exception.DuplicatedGroupName;
import com.secretpal.domain.model.Group;
import com.secretpal.domain.service.GroupRepository;

import javax.inject.Inject;

public class GroupCommandService {

    private final GroupRepository groupRepository;

    @Inject
    public GroupCommandService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void addGroup(RegistrationCommandGroup registrationCommandGroup){
        if(isGroupNameAvailable(registrationCommandGroup.getName())){
            groupRepository.createGroup(Group.builder()
                    .name(registrationCommandGroup.getName())
                    .userAdmin(registrationCommandGroup.getUserAdmin())
                    .users(registrationCommandGroup.getUsers())
                    .events(registrationCommandGroup.getEvents()).build());
        }else {
            throw new DuplicatedGroupName(registrationCommandGroup.getName());
        }
    }

    private boolean isGroupNameAvailable(String name) {
        return groupRepository.findByName(name).isEmpty();
    }
}
