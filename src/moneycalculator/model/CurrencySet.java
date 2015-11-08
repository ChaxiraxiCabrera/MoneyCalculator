package moneycalculator.model;

import java.util.ArrayList;

public class CurrencySet {
    private ArrayList<Currency> list = new ArrayList<>();
    
    public void add(Currency currency){
        list.add(currency);
    }

    public Currency get (String text){
        for (Currency currency : list) {
            if(currency.getCode().equalsIgnoreCase(text) 
                    || currency.getName().contains(text) 
                    || currency.getSymbol().equals(text)){
                return currency;
            }
        }
        return null;
    }
}