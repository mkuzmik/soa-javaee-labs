package soa.hibernate.library.book;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soa.hibernate.library.author.Author;
import soa.hibernate.library.author.AuthorRepository;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {

  private BookRepository bookRepository;
  private AuthorRepository authorRepository;

  @RequestMapping(value = "/book", method = RequestMethod.POST)
  public void create(@RequestBody BookData bookData) {
    Author author = authorRepository.getById(bookData.getAuthorId()).orElse(null);
    Book book = new Book(bookData.getTitle(), author);
    bookRepository.create(book);
  }

  @RequestMapping(value = "/book", method = RequestMethod.GET)
  public List<Book> getAll() {
    return bookRepository.getAll();
  }

  @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
  public Book getById(@PathVariable String id) {
    return bookRepository.getById(Integer.parseInt(id)).orElse(null);
  }
}
