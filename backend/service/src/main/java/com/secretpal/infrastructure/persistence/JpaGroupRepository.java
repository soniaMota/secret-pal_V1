package com.secretpal.infrastructure.persistence;

import com.secretpal.domain.model.Group;
import com.secretpal.domain.service.GroupRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import static java.util.stream.Collectors.toList;

@Stateless
public class JpaGroupRepository implements GroupRepository {

    @PersistenceContext(unitName = "backend")
    EntityManager manager;

    @Override
    public void createGroup(Group group) {
        var entity = new JpaGroupEntity();
        entity.setName(group.getName());
        entity.setUserAdmin(group.getUserAdmin());
        entity.setUsers(group.getUsers());
        entity.setEvents(group.getEvents());
        manager.persist(entity);
    }

    @Override
    public Optional<Group> findByName(String name) {
        try {
            return Optional.of(toModel(manager.createNamedQuery("findByName", JpaGroupEntity.class)
                    .setParameter("name", name).getSingleResult()));
        } catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public List<Group> allGroups() {
        return manager.createNamedQuery("findAllNameGroups", JpaGroupEntity.class).getResultList()
                .stream().map(this::toModel).collect(toList());
    }

    private Group toModel(JpaGroupEntity entity) {
        return Group.builder()
                .name(entity.getName())
                .userAdmin(entity.getUserAdmin())
                .users(entity.getUsers())
                .events(entity.getEvents())
                .build();
    }

}
