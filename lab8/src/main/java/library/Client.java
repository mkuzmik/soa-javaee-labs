package library;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Client {

  @Id
  @GeneratedValue
  private long id;

  @Embedded
  private PersonalData personalData;

  @OneToMany(mappedBy = "client")
  private Collection<Borrowing> borrowings;
}
