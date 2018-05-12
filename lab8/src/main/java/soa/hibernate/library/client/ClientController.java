package soa.hibernate.library.client;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import soa.hibernate.library.PersonalData;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController {

  private ClientRepository clientRepository;

  @RequestMapping(value = "/client", method = RequestMethod.POST)
  public void create(@RequestBody PersonalData personalData ) {
    clientRepository.create(new Client(personalData));
  }

  @RequestMapping(value = "/client", method = RequestMethod.GET)
  public List<Client> getAll() {
    return clientRepository.getAll();
  }

  @RequestMapping(value = "/client/{id}", method = RequestMethod.GET)
  public Client getById(@PathVariable String id) {
    return clientRepository.getById(Integer.parseInt(id)).orElse(null);
  }
}
