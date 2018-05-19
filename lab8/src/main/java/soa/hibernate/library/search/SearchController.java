package soa.hibernate.library.search;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import soa.hibernate.library.client.Client;

import java.util.Collection;

@RestController
@AllArgsConstructor
public class SearchController {

  private SearchRepository searchRepository;

  @RequestMapping(value = "/search/clients/author")
  public Collection<Client> clientsThatBorrowedBooksOf(@RequestParam String authorSurname) {
    return searchRepository.clentsThatBorrowedBooksOf(authorSurname);
  }
}
