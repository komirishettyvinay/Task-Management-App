package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestMyDatabaseConnection {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/TaskManagement?user=root&password=root"; // Updated URL
    // User and password are now included in the URL

    public static Connection getConnection() throws SQLException {
        try {
            // Register the MySQL JDBC driver (if needed for older versions of Java)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Return the connection to the database
            return DriverManager.getConnection(URL);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("MySQL JDBC Driver not found.");
        }
    }
}
