package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    // Create permanent connection
    public static Connection getConnection() {
        Connection connection = null;
        try {

            String url = "jdbc:mysql://localhost/";
            String dbName = "DeFalco";
            String driver = "com.mysql.jdbc.Driver";
            String userName = "root";
            String password = "michelemenzione";

            Class.forName(driver);
            connection = DriverManager.getConnection(url + dbName, userName, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
