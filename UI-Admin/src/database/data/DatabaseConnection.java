package database.data;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private DatabaseConnection() throws SQLException {
String server = "localhost";
        String port = "8000";
        String database = "book_store";
        String userName = "root";
        String password = "Ph0925789781";
        connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database, userName, password);
    }

   

    public Connection getConnection() {
 
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
