package com.secretpal.infrastructure.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "group", schema = "public")
@NamedQueries({
        @NamedQuery(name = "findAllGroups", query = "select g from JpaGroupEntity g")})
public class JpaGroupEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

}
