package soa.hibernate.library.book;

import org.springframework.stereotype.Component;
import soa.hibernate.library.Repository;

@Component
public class BookRepository extends Repository<Book> {

  @Override
  public Class getClazz() {
    return Book.class;
  }
}
