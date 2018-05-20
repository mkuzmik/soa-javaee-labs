package currency;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import ws.exchange.CurrencyService;
import ws.exchange.CurrencyService_Service;
import ws.helloworld.*;

@WebServlet("/currency")
public class CurrencyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HelloWorldService_Service helloWorldService_service = new HelloWorldService_Service();
    HelloWorldService helloWorld = helloWorldService_service.getHelloWorld();

    CurrencyService_Service currencyService_service = new CurrencyService_Service();
    CurrencyService currencyService = currencyService_service.getCurrency();

    String action = req.getParameter("action");
    String symbol = req.getParameter("symbol");
    double amount = Double.valueOf(Optional.ofNullable(req.getParameter("amount")).orElse("0"));

    switch (action) {
      case "exchange":
        writeResponse(Double.toString(currencyService.sell(symbol, amount)), 200, resp);
        break;
      case "checkRate":
        writeResponse(Double.toString(currencyService.getExchangeRate(symbol)), 200, resp);
        break;
      default:
        writeResponse("unknown action", 400, resp);
        break;
    }
  }

  private void writeResponse(String content, int status, HttpServletResponse response) throws IOException {
    response.setStatus(status);
    response.getWriter().write(content);
    response.getWriter().flush();
    response.getWriter().close();
  }
}
