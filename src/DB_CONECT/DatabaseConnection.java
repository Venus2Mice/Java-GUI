package DB_CONECT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;
    private static String DB_URL = "jdbc:mysql://localhost:3307/libarymanager";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";

    private DatabaseConnection() throws SQLException {
        try {
             Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
            System.out.println("Connect to database sucessfully!");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database connection failed " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        return connection.createStatement().executeQuery(sql);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }
    public static void main(String[] args) {
        
    }
}
