package soa.hibernate.library.client;

import org.springframework.stereotype.Component;
import soa.hibernate.library.Repository;

@Component
public class ClientRepository extends Repository<Client> {

  @Override
  public Class getClazz() {
    return Client.class;
  }
}
