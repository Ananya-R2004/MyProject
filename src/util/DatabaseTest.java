package util;
import java.sql.Connection;

public class DatabaseTest {
    public static void main(String[] args) {
        Connection conn = DatabaseUtil.connect();
        if (conn != null) {
            System.out.println("Database connection successful!");
        } else {
            System.out.println("Database connection failed.");
        }
    }
}
