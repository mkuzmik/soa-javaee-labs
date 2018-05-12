package soa.hibernate.library.author;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import soa.hibernate.library.book.Book;
import soa.hibernate.library.PersonalData;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Author {

  @Id
  @GeneratedValue
  private int id;

  @Embedded
  private PersonalData personalData;

  @OneToMany(mappedBy = "author")
  @JsonIgnore
  private Collection<Book> books;

  public Author(PersonalData personalData) {
    this.personalData = personalData;
  }
}
