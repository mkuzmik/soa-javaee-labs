package currency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import ws.helloworld.*;

@WebServlet("/currency")
public class CurrencyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HelloWorldService_Service helloWorldService_service = new HelloWorldService_Service();
    HelloWorldService helloWorld = helloWorldService_service.getHelloWorld();

    writeResponse(helloWorld.sayHello(), 200, resp);
  }

  private void writeResponse(String content, int status, HttpServletResponse response) throws IOException {
    response.setStatus(status);
    response.getWriter().write(content);
    response.getWriter().flush();
    response.getWriter().close();
  }
}
