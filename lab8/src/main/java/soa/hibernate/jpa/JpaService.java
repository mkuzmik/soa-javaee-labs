package soa.hibernate.jpa;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Service
public class JpaService {

  private EntityManagerFactory entityManagerFactory;

  public JpaService() {
    entityManagerFactory = Persistence.createEntityManagerFactory("postgresDb");
  }

  public EntityManager getEntityManager() {
    return entityManagerFactory.createEntityManager();
  }
}
