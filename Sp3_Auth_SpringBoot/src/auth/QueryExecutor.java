package auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryExecutor {
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/prathik";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "prathik";
    
    public boolean registerUser(String userName, String password) {
    	
    	String nameCheck = userName; 
        String emailPattern = "^.+@.+\\..+$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(nameCheck);
        if (matcher.matches()) {
        	String sql = "INSERT INTO user (userName, password) VALUES (?, ?)";
        	try (
                    Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                    PreparedStatement preparedStatement = connection.prepareStatement(sql)
                ) {               
                    preparedStatement.setString(1, userName);
                    preparedStatement.setString(2, password);
                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println(userName + " added successfully to Database.");
                        return true;
                    } else {
                        System.out.println("Failed to add user.");
                        return false;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        } else {
            System.out.println("Username does not have a valid email format.");
        }
    	return false;
    }
    
    public boolean loginCheck(String userName, String password) {
    	String sql = "SELECT * FROM user WHERE userName = ? AND password = ?";
        try (
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Login successful. Welcome " + resultSet.getString("username"));
                return true;
            } else {
                System.out.println("Invalid username or password. Please try again.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteUser(String userName, String password) {
    	String sql = "DELETE FROM user WHERE userName = ? AND password = ?";
    	try (
                Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
            ) {
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected>0) {
                    System.out.println("Deleted successfully. ThankYou ");
                    return true;
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
    }
    
    public boolean updateDetails(String userName, String password, String newPassword) {
    	String updateQuery = "UPDATE user SET password = ? WHERE userName = ?";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            // Set parameters
            statement.setString(1, newPassword);
            statement.setString(2, userName);

            // Execute the update statement
            int rowsAffected = statement.executeUpdate();

            // Check if the password was updated successfully
            if (rowsAffected > 0) {
                System.out.println("Password updated successfully.");
                return true;
            } else {
                System.out.println("User not found or password update failed.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}