package com.secretpal.infrastructure.persistence;

import com.secretpal.domain.model.Group;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "event", schema = "public")

@NamedQueries({
        @NamedQuery(name = "findAllEvents", query = "select e from JpaEventEntity e"),
        @NamedQuery(name = "findAllEventsByDate", query = "select e.name, e.event_date from JpaEventEntity e where e.event_date>now() order by e.event_date ASC"),
        @NamedQuery(name = "findByName", query = "select e from JpaEventEntity e where e.name = :name")})
public class JpaEventEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "event_date")
    private LocalDateTime dateTime;

    @Column(name = "budget")
    private int budget;

    @Column(name = "children_budget")
    private int childrenBudget;

    @Column(name = "place")
    private String place;

    @Column(name = "raffled_of")
    private boolean raffled_of;

    @ManyToOne
    @JoinColumn(name = "id")
    private Group group;
}
