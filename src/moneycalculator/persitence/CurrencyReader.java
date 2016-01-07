package moneycalculator.persitence;

import java.util.ArrayList;
import moneycalculator.model.Currency;

public interface CurrencyReader {
    ArrayList<Currency> get();
}
