package soa.hibernate.library.client;

import lombok.Data;
import soa.hibernate.library.PersonalData;
import soa.hibernate.library.borrowing.Borrowing;

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
