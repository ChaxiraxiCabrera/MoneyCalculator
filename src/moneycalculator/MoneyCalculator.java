package moneycalculator;

import moneycalculator.control.ExchangeCommand;
import moneycalculator.process.MoneyExchanger;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.persitence.MockExchangeRateReader;
import moneycalculator.ui.MockCurrencyDialog;
import moneycalculator.ui.MockMoneyDialog;
import moneycalculator.ui.MockMoneyDisplay;

public class MoneyCalculator {

    public static void main(String[] args) {
        Currency currency = new Currency("USD", "dolar americano", "$");
        Currency currency1 = new Currency("EUR", "Euro", "€");
        Money money = new Money(300, currency);
        ExchangeRate exchangeRate = new ExchangeRate(currency, currency1, 1.21);
       
        ExchangeCommand exchangeCommand = new ExchangeCommand(new MockMoneyDialog(),
                                                    new MockCurrencyDialog(),
                                                    new MockExchangeRateReader(),
                                                    new MockMoneyDisplay());
        exchangeCommand.execute();
    }
    
}
