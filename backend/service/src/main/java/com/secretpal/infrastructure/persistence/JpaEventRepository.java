package com.secretpal.infrastructure.persistence;

import com.secretpal.domain.model.Event;
import com.secretpal.domain.service.EventRepository;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

import lombok.Data;

import static java.util.stream.Collectors.toList;

@Stateless
public class JpaEventRepository implements EventRepository {

    @PersistenceContext(unitName = "backend")
    EntityManager manager;

    @Override
    public void createEvent(Event event) {
        var entity = new JpaEventEntity();
        entity.setName(event.getName());
        entity.setDateTime(event.getDateTime());
        entity.setBudget(event.getBudget());
        entity.setChildrenBudget(event.getChildrenBudget());
        entity.setPlace(event.getPlace());
        entity.setRaffled_of(event.isRaffled_of());
        entity.setGroup(event.getGroup());
        manager.persist(entity);
    }

    @Override
    public Optional<Event> findByNameEvent(String name) {
        try{
            return  Optional.of(toModel(manager.createNamedQuery("findByName", JpaEventEntity.class)
            .setParameter("name", name).getSingleResult()));
        } catch (NoResultException e){
            return Optional.empty();
        }
    }

    @Override
    public List<Event> allEvents() {
        return manager.createNamedQuery("findAllEvents", JpaEventEntity.class).getResultList()
                .stream().map(this::toModel).collect(toList());
    }

    @Override
    public List<Event> allEventsByDate() {
        return manager.createNamedQuery("findAllEventsByDate", JpaEventEntity.class).getResultList()
                .stream().map(this::toModel).collect(toList());
    }

    private Event toModel(JpaEventEntity entity) {
        return Event.builder()
                .name(entity.getName())
                .dateTime(entity.getDateTime())
                .budget(entity.getBudget())
                .childrenBudget(entity.getChildrenBudget())
                .place(entity.getPlace())
                .raffled_of(entity.isRaffled_of())
                .group(entity.getGroup())
                .build();
    }
}
