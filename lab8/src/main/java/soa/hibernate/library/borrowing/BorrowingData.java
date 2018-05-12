package soa.hibernate.library.borrowing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowingData {

  private Date borrowingDate;
  private Date returningDate;
  private int bookId;
  private int clientId;
}
