package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

  public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgresDb");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();

    // Check database version
    String sql = "select version()";

    String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
    System.out.println(result);

    entityManager.getTransaction().commit();
    entityManager.close();

    entityManagerFactory.close();
  }
}
