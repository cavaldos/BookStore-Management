package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Order;
import store.utils.DatabaseUtils;

public class UserDao {
    // select user
    public boolean selectUser(int userID) throws SQLException {
        Connection connection = DatabaseUtils.connectToDatabase();
        String query = "SELECT * FROM account WHERE userID = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error selecting user: " + e.getMessage());
            throw e;
        } finally {
            connection.close();
        }
    }
}
