package library;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Author {

  @Id
  @GeneratedValue
  private int id;

  @Embedded
  private PersonalData personalData;

  @OneToMany(mappedBy = "author")
  private Collection<Book> books;
}
