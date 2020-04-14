package com.secretpal.infrastructure.persistence;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Data
@Entity
@Table(name = "user", schema = "public")
@NamedQueries({
    @NamedQuery(name = "findAll", query = "select u from JpaUserEntity u"),
    @NamedQuery(name = "findByMail", query = "select u from JpaUserEntity u where u.mail = :mail")})
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

