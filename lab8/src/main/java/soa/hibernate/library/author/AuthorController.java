package soa.hibernate.library.author;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soa.hibernate.library.PersonalData;

import java.util.List;

@RestController("/author")
@AllArgsConstructor
public class AuthorController {

  private AuthorRepository authorRepository;

  @RequestMapping(method = RequestMethod.POST)
  public void create(@RequestBody PersonalData personalData) {
    Author author = new Author(personalData);
    authorRepository.create(author);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Author> getAll() {
    return authorRepository.getAll();
  }

  @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
  public Author getById(@PathVariable String id) {
    return authorRepository.getById(Integer.parseInt(id)).orElse(null);
  }
}
