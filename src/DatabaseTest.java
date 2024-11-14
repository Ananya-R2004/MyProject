import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseTest {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:D:/EmployeePerformanceAnalysis/mydatabase.db";  // change path as needed

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                System.out.println("Connected to the SQLite database.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
