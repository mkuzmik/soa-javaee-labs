package ws.exchange;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface CurrencyService {

  @WebMethod
  public double getExchangeRate(String symbol);

  @WebMethod
  public double sell(String symbol, double amount);
}
