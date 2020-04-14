package com.secretpal.infrastructure.persistence;

import com.secretpal.domain.model.User;
import com.secretpal.domain.service.UserRepository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;

import static java.util.stream.Collectors.toList;

@Stateless
public class JpaUserRepository implements UserRepository {

  @PersistenceContext(unitName = "backend")
  EntityManager manager;

  @Override
  public void createUser(User user, String password) {
    var entity = new JpaUserEntity();
    entity.setName(user.getName());
    entity.setMail(user.getMail());
    entity.setAge(user.getAge());
    entity.setPasswordHash(DigestUtils.md5Hex(password));
    manager.persist(entity);
  }

  @Override
  public List<User> allUsers() {
    return manager.createNamedQuery("findAll", JpaUserEntity.class).getResultList()
        .stream().map(this::toModel).collect(toList());
  }

  @Override
  public Optional<User> findByMail(String mail) {
    try {
      return Optional.of(toModel(manager.createNamedQuery("findByMail", JpaUserEntity.class)
          .setParameter("mail", mail).getSingleResult()));
    } catch (NoResultException e) {
      return Optional.empty();
    }
  }

  private User toModel(JpaUserEntity entity) {
    return User.builder()
        .age(entity.getAge())
        .mail(entity.getMail())
        .phone(entity.getPhone())
        .name(entity.getName())
        .build();
  }
}
