package moneycalculator;

import moneycalculator.process.MoneyExchanger;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;

public class MoneyCalculator {

    public static void main(String[] args) {
        Currency currency = new Currency("USD", "dolar americano", "$");
        Currency currency1 = new Currency("EUR", "Euro", "€");
        Money money = new Money(300, currency);
        ExchangeRate exchangeRate = new ExchangeRate(currency, currency1, 1.21);
       
        System.out.println(MoneyExchanger.exchange(money, exchangeRate).getAmount()+currency.getSymbol());
    }
    
}
