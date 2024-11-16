package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:sqlite:database/employee_performance.db";
    
    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL);
            System.out.println("Connection to SQLite established successfully.");
        } catch (SQLException e) {
            System.err.println("Failed to connect to SQLite: " + e.getMessage());
        }
        return connection;
    }

    public static void initializeDatabase() {
        String createEmployeesTable = "CREATE TABLE IF NOT EXISTS employees (" +
                                      "employee_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                      "name TEXT NOT NULL, " +
                                      "department_id INTEGER, " +
                                      "position TEXT, " +
                                      "salary REAL, " +
                                      "FOREIGN KEY (department_id) REFERENCES departments(department_id));";

        String createDepartmentsTable = "CREATE TABLE IF NOT EXISTS departments (" +
                                        "department_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        "name TEXT NOT NULL);";

        String createPerformanceReviewsTable = "CREATE TABLE IF NOT EXISTS performance_reviews (" +
                                               "review_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                               "employee_id INTEGER, " +
                                               "review_date TEXT, " +
                                               "performance_score INTEGER, " +
                                               "comments TEXT, " +
                                               "FOREIGN KEY (employee_id) REFERENCES employees(employee_id));";

        try (Connection connection = connect();
             Statement statement = connection.createStatement()) {

            statement.execute(createDepartmentsTable);
            statement.execute(createEmployeesTable);
            statement.execute(createPerformanceReviewsTable);

            System.out.println("Tables initialized successfully.");
        } catch (SQLException e) {
            System.err.println("Error while initializing database: " + e.getMessage());
        }
    }
}
