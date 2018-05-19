package soa.hibernate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import soa.hibernate.library.PersonalData;
import soa.hibernate.library.author.Author;
import soa.hibernate.library.author.AuthorRepository;
import soa.hibernate.library.book.Book;
import soa.hibernate.library.book.BookRepository;
import soa.hibernate.library.borrowing.BorrowingRepository;
import soa.hibernate.library.client.ClientRepository;

import java.util.Arrays;

@SpringBootApplication
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(AuthorRepository authorRepository, BookRepository bookRepository,
                                             BorrowingRepository borrowingRepository, ClientRepository clientRepository) {
    return args -> {
//      Arrays.stream((new Author[]{
//              new Author(new PersonalData("Adam", "Mickiewicz")),
//              new Author(new PersonalData("Juliusz", "Slowacki")),
//              new Author(new PersonalData("Henryk", "Sienkiewicz"))
//      })).forEach(authorRepository::create);

//      Arrays.stream((new Book[]{
//              new Book("W pustyni i w puszczy", authors[3])
//      })).forEach(bookRepository::create);
    };
  }
}
