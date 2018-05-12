package soa.hibernate.library.book;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import soa.hibernate.library.borrowing.Borrowing;
import soa.hibernate.library.author.Author;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Book {

  @Id
  @GeneratedValue
  private int id;

  private String title;

  @ManyToOne(optional = false)
  private Author author;

  @OneToMany(mappedBy = "book")
  @JsonIgnore
  private Collection<Borrowing> borrowings;

  public Book(String title, Author author) {
    this.title = title;
    this.author = author;
  }
}
