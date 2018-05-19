package soa.hibernate.library.search;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import soa.hibernate.jpa.JpaService;
import soa.hibernate.library.client.Client;

import javax.persistence.EntityManager;
import java.util.Collection;

@Component
@AllArgsConstructor
public class SearchRepository {

  private JpaService jpaService;

  public Collection<Client> clentsThatBorrowedBooksOf(String authorSurname) {
    EntityManager entityManager = jpaService.getEntityManager();

    return entityManager.createQuery("select c from " +
            "Client c join Borrowing b join Book bo join Author a" +
            " where a.surname = :surname")
            .setParameter("surname", authorSurname)
            .getResultList();
  }
}
