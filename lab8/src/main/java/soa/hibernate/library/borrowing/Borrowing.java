package soa.hibernate.library.borrowing;

import lombok.Data;
import lombok.NoArgsConstructor;
import soa.hibernate.library.client.Client;
import soa.hibernate.library.book.Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class Borrowing {

  @Id
  @GeneratedValue
  private int id;

  @ManyToOne(optional = false)
  private Client client;

  @ManyToOne(optional = false)
  private Book book;

  private Date borrowingDate;

  private Date returningDate;

  public Borrowing(Client client, Book book, Date borrowingDate, Date returningDate) {
    this.client = client;
    this.book = book;
    this.borrowingDate = borrowingDate;
    this.returningDate = returningDate;
  }
}
