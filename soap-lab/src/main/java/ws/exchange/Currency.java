package ws.exchange;

import java.util.Arrays;

public enum Currency {

  USD("USD", 3.5342d),
  EURO("EUR", 4.221d);

  private String symbol;

  private double exchangeRate;

  Currency(String symbol, double exchangeRate) {
    this.symbol = symbol;
    this.exchangeRate = exchangeRate;
  }

  public double exchange(double amount) {
    return amount * getExchangeRate();
  }

  public String getSymbol() {
    return symbol;
  }

  public double getExchangeRate() {
    return exchangeRate;
  }

  public static Currency of(String symbol) {
    return Arrays.stream(Currency.values())
            .filter(currency -> currency.getSymbol().equals(symbol))
            .findFirst()
            .orElse(null);
  }
}
