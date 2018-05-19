package ws.helloworld;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public interface HelloWorldService {

  @WebMethod
  String sayHello();

  @WebMethod
  String sayHelloToName(String name);

  @WebMethod
  String sayHelloToNames(List<String> names);
}
