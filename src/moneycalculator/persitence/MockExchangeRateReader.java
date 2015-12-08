package moneycalculator.persitence;

import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

public class MockExchangeRateReader implements ExchangeRateReader{

    public MockExchangeRateReader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExchangeRate get(Currency from, Currency to){
        return new ExchangeRate(from, to, 1.5);
    }
    
}
