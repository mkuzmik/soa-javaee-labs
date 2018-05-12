package soa.hibernate.library.author;

import org.springframework.stereotype.Component;
import soa.hibernate.library.Repository;

@Component
public class AuthorRepository extends Repository<Author> {

  @Override
  public Class getClazz() {
    return Author.class;
  }
}
