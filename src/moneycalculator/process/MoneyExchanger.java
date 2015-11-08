package moneycalculator.process;

import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;

public class MoneyExchanger {
    
    public static Money exchange (Money money, ExchangeRate rate){
        Money result = new Money(money.getAmount() * rate.getRate(), rate.getTo());
        return result;
    }
}
