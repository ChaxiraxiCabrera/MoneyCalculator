package moneycalculator;

public class MoneyExchanger {
    
    public static Money exchange (Money money, ExchangeRate rate){
        Money result = new Money(money.getAmount() * rate.getRate(), rate.getTo());
        return result;
    }
}
