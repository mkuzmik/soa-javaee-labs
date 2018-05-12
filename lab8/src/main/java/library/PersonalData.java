package library;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class PersonalData {

  private String name;

  private String surname;
}
