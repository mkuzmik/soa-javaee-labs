package ws.exchange;

import javax.jws.WebService;

@WebService(serviceName = "CurrencyService", portName= "Currency", endpointInterface = "ws.exchange.CurrencyService")
public class CurrencyServiceImpl implements CurrencyService {

  @Override
  public double getExchangeRate(String symbol) {
    return Currency.of(symbol).getExchangeRate();
  }

  @Override
  public double sell(String symbol, double amount) {
    return Currency.of(symbol).exchange(amount);
  }
}
