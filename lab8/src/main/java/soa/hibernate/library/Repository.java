package soa.hibernate.library;

import org.springframework.beans.factory.annotation.Autowired;
import soa.hibernate.jpa.JpaService;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public abstract class Repository<T> {

  @Autowired
  protected JpaService jpaService;

  public abstract Class getClazz();

  public void create(T obj) {
    EntityManager entityManager = jpaService.getEntityManager();
    entityManager.getTransaction().begin();
    entityManager.persist(obj);
    entityManager.getTransaction().commit();
    entityManager.close();
  }

  public List<T> getAll() {
    EntityManager entityManager = jpaService.getEntityManager();
    List resultList = entityManager.createQuery("select a from " + getClazz().getName() + " a").getResultList();
    return resultList;
  }

  public Optional<T> getById(int id) {
    EntityManager entityManager = jpaService.getEntityManager();

    Optional<T> maybe = entityManager.createQuery("select a from " + getClazz().getName() + " a where a.id = :id")
            .setParameter("id", id)
            .getResultList().stream().findFirst();
    return maybe;
  }
}
