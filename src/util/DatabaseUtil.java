package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String DB_URL = "jdbc:sqlite:D:/EmployeePerformanceAnalysis/database/employee_performance.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            // Load the SQLite JDBC driver (required in some environments)
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Connection to SQLite has been established.");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return conn;
    }
}
