package soa.hibernate.library.client;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import soa.hibernate.library.PersonalData;
import soa.hibernate.library.borrowing.Borrowing;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
public class Client {

  @Id
  @GeneratedValue
  private int id;

  @Embedded
  private PersonalData personalData;

  @OneToMany(mappedBy = "client")
  @JsonIgnore
  private Collection<Borrowing> borrowings;

  public Client(PersonalData personalData) {
    this.personalData = personalData;
  }
}
