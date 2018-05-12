package soa.hibernate.library.borrowing;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soa.hibernate.library.book.Book;
import soa.hibernate.library.book.BookRepository;
import soa.hibernate.library.client.Client;
import soa.hibernate.library.client.ClientRepository;

import java.util.List;

@RestController
@AllArgsConstructor
public class BorrowingController {

  private BorrowingRepository borrowingRepository;
  private BookRepository bookRepository;
  private ClientRepository clientRepository;

  @RequestMapping(value = "/borrowing", method = RequestMethod.POST)
  public void create(@RequestBody BorrowingData borrowingData) {
    Client client = clientRepository.getById(borrowingData.getClientId()).orElse(null);
    Book book = bookRepository.getById(borrowingData.getBookId()).orElse(null);
    borrowingRepository.create(new Borrowing(client, book, borrowingData.getBorrowingDate(), borrowingData.getReturningDate()));
  }

  @RequestMapping(value = "/borrowing", method = RequestMethod.GET)
  public List<Borrowing> getAll() {
    return borrowingRepository.getAll();
  }

  @RequestMapping(value = "/borrowing/{id}", method = RequestMethod.GET)
  public Borrowing getById(@PathVariable String id) {
    return borrowingRepository.getById(Integer.parseInt(id)).orElse(null);
  }
}
