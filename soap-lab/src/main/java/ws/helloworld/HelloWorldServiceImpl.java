package ws.helloworld;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;


@WebService(serviceName = "HelloWorldService", portName = "HelloWorld", name = "HelloWorld", endpointInterface = "ws.helloworld.HelloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService {

  @Override
  public String sayHello() {
    return "Hello World!";
  }

  @Override
  public String sayHelloToName(final String name) {

    /* Create a list with just the one value */
    final List<String> names = new ArrayList<>();
    names.add(name);

    return sayHelloToNames(names);
  }

  @Override
  public String sayHelloToNames(final List<String> names) {
    return "Hello " + createNameListString(names);
  }

  private String createNameListString(final List<String> names) {

    /*
     * If the list is null or empty then assume the call was anonymous.
     */
    if (names == null || names.isEmpty()) {
      return "Anonymous!";
    }

    final StringBuilder nameBuilder = new StringBuilder();
    for (int i = 0; i < names.size(); i++) {

      /*
       * Add the separator if its not the first string or the last separator since that should be an and (&) symbol.
       */
      if (i != 0 && i != names.size() - 1)
        nameBuilder.append(", ");
      else if (i != 0 && i == names.size() - 1)
        nameBuilder.append(" & ");

      nameBuilder.append(names.get(i));
    }

    nameBuilder.append("!");

    return nameBuilder.toString();
  }
}
