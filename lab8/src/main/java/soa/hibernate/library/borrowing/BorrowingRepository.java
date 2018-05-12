package soa.hibernate.library.borrowing;

import org.springframework.stereotype.Component;
import soa.hibernate.library.Repository;

@Component
public class BorrowingRepository extends Repository<Borrowing> {

  @Override
  public Class getClazz() {
    return Borrowing.class;
  }
}
