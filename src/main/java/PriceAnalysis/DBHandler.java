package PriceAnalysis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {
    private static final String URL = "jdbc:mysql://localhost:3306/new_schema";
    private static final String PASSWORD = "root";
    private static final String USERNAME = "root";
    public static Statement statement;
    public static Connection connection;

    public static void getInfo() {

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) System.out.println("Connection received");
            statement = connection.createStatement();
            int res = statement.executeUpdate("UPDATE new_table SET name = 'Telefon', age = 3 WHERE id = 9;");
            System.out.println(res);
        } catch (SQLException e) {
            System.out.println("Ne podcluchilos");
            e.printStackTrace();
        }
    }
}
