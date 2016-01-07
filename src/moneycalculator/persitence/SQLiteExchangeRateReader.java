package moneycalculator.persitence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import moneycalculator.model.Currency;
import moneycalculator.model.ExchangeRate;

public class SQLiteExchangeRateReader implements ExchangeRateReader{

    @Override
    public ExchangeRate get(Currency from, Currency to) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:RATES.db");
            Statement statement = connection.createStatement();
            String fromQuery = "SELECT EXCHANGE_RATE_DOLLAR FROM RATES WHERE CURRENCY='"
                    + from.getCode()
                    + "'";
            String toQuery = "SELECT EXCHANGE_RATE_DOLLAR FROM RATES WHERE CURRENCY='" 
                    + to.getCode()
                    + "'";
            ResultSet  fromResult = statement.executeQuery(fromQuery);
            double fromExchange = 0;
            while(fromResult.next()){
                fromExchange = fromResult.getDouble(1);
            }
            ResultSet toResult = statement.executeQuery(toQuery);
            double toExchange = 0;
            while(toResult.next()){
                toExchange = toResult.getDouble(1);
            }
            fromResult.close();
            toResult.close();
            statement.close();
            connection.close();
            return new ExchangeRate(from, to, (toExchange/fromExchange));
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectarse con la Base de Datos");
        }

        return null;
    }
    
}
