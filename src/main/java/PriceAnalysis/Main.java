package PriceAnalysis;
import org.jsoup.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private static final String PASSWORD = "root";
    private static final String USERNAME = "root";
    public static Statement statement;
    public static Connection connection;

    public static void main(String[] args) throws MalformedURLException {

        try
        {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            if (!connection.isClosed()) System.out.println("Connection received");
            statement = connection.createStatement();
            int res = statement.executeUpdate("UPDATE new_table SET name = 'Telefon', age = 3 WHERE id = 9;");
            System.out.println(res);
        }
        catch (SQLException e)
        {
            System.out.println("Ne podcluchilos");
            e.printStackTrace();
        }
        /*URL url = new URL("https://autosakhcom.ru/sale/1620790");
        String ur1 = "https://autosakhcom.ru/sale/1620790";
        try {
            GetData.removeCode(ur1);
        }
        catch (Exception e)
        {
            System.out.println("Че то не так");
        }*/
        System.out.println("Вроде все ок");
    }
}