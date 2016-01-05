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
            
        ExchangeCommand exchangeCommand = new ExchangeCommand(new MockMoneyDialog(),
                                                    new MockCurrencyDialog(),
                                                    new MockMoneyDisplay(),
                                                    new MockExchangeRateReader());
        exchangeCommand.execute();
    }
    
}
