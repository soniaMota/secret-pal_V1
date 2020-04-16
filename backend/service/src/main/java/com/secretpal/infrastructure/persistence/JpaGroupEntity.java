package com.secretpal.infrastructure.persistence;

import com.secretpal.domain.model.Event;
import com.secretpal.domain.model.User;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "group", schema = "public")

@NamedQueries({
        @NamedQuery(name = "findAllNameGroups", query = "select g.name from JpaGroupEntity g"),
        @NamedQuery(name = "findByName", query = "select g from JpaGroupEntity g where g.name = :name")})
public class JpaGroupEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    //@ManyToOne
    //JoinColumn(name = "id")
    private User userAdmin;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Event> events;

}
