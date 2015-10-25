package moneycalculator;

public class MoneyCalculator {

    public static void main(String[] args) {
        Currency currency = new Currency("USD", "dolar americano", "$");
        Currency currency1 = new Currency("EUR", "Euro", "€");
        Money money = new Money(300, currency);
        ExchangeRate exchangeRate = new ExchangeRate(currency, currency1, 1.21);
        
        
    }
    
}
