package auth;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/prathik";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "prathik";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Establishing a connection to the MySQL database
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            if (connection != null) {
                System.out.println("Connected to the database!");
                // You can perform database operations here
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to connect to the database");
            e.printStackTrace();
        } finally {
            // Closing the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
