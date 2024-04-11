package store.utils;

import java.sql.*;

import javax.sql.PooledConnection;
import javax.xml.crypto.Data;

import com.mysql.cj.xdevapi.PreparableStatement;

public class DatabaseUtils {
    private static String url;
    private static String user;
    private static String password;

    public DatabaseUtils() {
        this.url = "jdbc:mysql://localhost:3307/bookstore";
        this.user = "root";
        this.password = "123456";
    }

    public DatabaseUtils(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    // Change the access modifier to public
    public static Connection connect() throws ClassNotFoundException, SQLException {
        // Load the MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Establish a connection
        Connection connection = DriverManager.getConnection(url, user, password);

        // Chọn cơ sở dữ liệu
        try (Statement statement = connection.createStatement()) {
            statement.execute("USE book_store;");
        }

        return connection;
    }

    public void printTableNames() {
        try (Connection conn = connect()) {
            // Get DatabaseMetaData
            DatabaseMetaData dbmd = conn.getMetaData();
            // Get a list of tables
            ResultSet rs = dbmd.getTables(null, null, null, new String[] { "TABLE" });
            // Print the table names
            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }

    public PreparableStatement prepareStatement(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'prepareStatement'");
    }

    public static Connection connectToDatabase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'connectToDatabase'");
    }

    public static void closeConnection(Connection connection) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeConnection'");
    }

}

/*
 * 
 * 
 * 
 * DatabaseUtils databaseUtils = new DatabaseUtils();
 * 
 * try {
 * databaseUtils.connect();
 * System.out.println("Kết nối thành công");
 * databaseUtils.printTableNames();
 * } catch (ClassNotFoundException e) {
 * System.out.println("Không tìm thấy driver cơ sở dữ liệu: " + e.getMessage());
 * }
 * 
 * 
 * 
 * private PooledConnection connectPool() throws ClassNotFoundException,
 * SQLException {
 * // Load the MySQL JDBC driver
 * Class.forName("com.mysql.cj.jdbc.Driver");
 * // Establish a connection
 * Connection conn = DriverManager.getConnection(url, user, password);
 * return conn.unwrap(PooledConnection.class);
 * }
 * // using
 * 
 * public void printTableNames() {
 * try (Connection conn = connect()) {
 * // Get DatabaseMetaData
 * DatabaseMetaData dbmd = conn.getMetaData();
 * // Get a list of tables
 * ResultSet rs = dbmd.getTables(null, null, null, new String[] { "TABLE" });
 * // Print the table names
 * while (rs.next()) {
 * System.out.println(rs.getString("TABLE_NAME"));
 * }
 * } catch (ClassNotFoundException e) {
 * System.out.println("MySQL JDBC driver not found");
 * e.printStackTrace();
 * } catch (SQLException e) {
 * System.out.println("Error connecting to the database");
 * e.printStackTrace();
 * }
 * }
 * 
 * 
 */