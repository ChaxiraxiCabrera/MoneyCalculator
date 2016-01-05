package moneycalculator.model;

import java.util.ArrayList;

public class CurrencySet {
    private final ArrayList<Currency> list ;

    public CurrencySet() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Currency> getList() {
        return list;
    }
    
    
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
    
    public Currency[] currencies (){
        return this.list.toArray(new Currency[list.size()]);
    }
}