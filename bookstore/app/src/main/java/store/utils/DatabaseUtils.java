package store.utils;

import java.sql.*;


public class DatabaseUtils {
    private static String url;
    private static String user;
    private static String password;

    public DatabaseUtils() {
        url = "jdbc:mysql://localhost:3307/book_store";
        user = "root";
        password = "123456";
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

}

