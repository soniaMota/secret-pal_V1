package com.secretpal.infrastructure.persistence;

import com.secretpal.domain.model.Group;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Data;

import static java.time.LocalDateTime.now;

@Data
@Entity
@Table(name = "user", schema = "public")
@NamedQueries({
    @NamedQuery(name = "findAll", query = "select u from JpaUserEntity u"),
    @NamedQuery(name = "findByMail", query = "select u from JpaUserEntity u where u.mail = :mail"),
    @NamedQuery(name = "findAllByNameAndAge", query = "select u.name, u.age from JpaUserEntity u")})
public class JpaUserEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "fullname")
  private String name;

  @Column(name = "mail", unique = true)
  private String mail;

  @Column(name = "age")
  private Integer age;

  @Column(name = "phone_number")
  private String phone;

  @ManyToMany(mappedBy = "users")
  @JoinTable(name = "user-group", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "group_id")})
  private List<Group> groups;

  @Column(name = "password_hash")
  private String passwordHash;

  @Column(name = "last_update")
  private LocalDateTime lastUpdate;

  @PreUpdate
  @PrePersist
  public void setLastUpdate() {
    this.lastUpdate = now();
  }

}

