package library;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Book {

  @Id
  @GeneratedValue
  private long id;

  private String title;

  @ManyToOne(optional = false)
  private Author author;

  @OneToMany(mappedBy = "book")
  private Collection<Borrowing> borrowings;
}
