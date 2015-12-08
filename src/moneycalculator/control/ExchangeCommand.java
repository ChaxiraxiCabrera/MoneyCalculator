package moneycalculator.control;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;
import moneycalculator.model.Money;
import moneycalculator.persitence.ExchangeRateReader;
import moneycalculator.process.MoneyExchanger;
import moneycalculator.ui.CurrencyDialog;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyDisplay;


public class ExchangeCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyDisplay moneyDisplay;
    private final ExchangeRateReader exchangeRateReader;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyDisplay moneyDisplay, ExchangeRateReader exchangeRateReader) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyDisplay = moneyDisplay;
        this.exchangeRateReader = exchangeRateReader;
    }
    
    @Override
    public void execute(){
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();
        ExchangeRate exchangeRate = exchangeRateReader.get(currency, currency);
        Money result = MoneyExchanger.exchange(money, exchangeRate);
        moneyDisplay.show(result);
    }
}
