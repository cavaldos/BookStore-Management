package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.utils.DatabaseUtils;
import store.Model.User;

// import  PasswordHasher
import store.utils.PasswordHasher;

public class UserDao {

    //

    // add user
    public void addUser(User user) throws SQLException {
        String query = "INSERT INTO account ( username, password, status, firstname, lastname, role) VALUES (?,?,?,?,?,?)";

        new DatabaseUtils();
        try {
            Connection connection = DatabaseUtils.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            String hashedPassword = PasswordHasher.hashPassword(user.getPassword());
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setBoolean(3, true);
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // update user
    public boolean updateUser(User user) throws SQLException {
        String query = "UPDATE account SET username = ?, password = ?, status = ?, firstname = ?, lastname = ?, role = ? WHERE userID = ?";
        new DatabaseUtils();
        try {
            Connection connection = DatabaseUtils.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            String hashedPassword = PasswordHasher.hashPassword(user.getPassword());
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setBoolean(3, user.getStatus());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.setInt(7, user.getUserID());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePassword(User user) throws SQLException {
        String query = "UPDATE account SET username = ?, password = ?, status = ?, firstname = ?, lastname = ?, role = ? WHERE userID = ?";
        new DatabaseUtils();
        try {
            Connection connection = DatabaseUtils.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUserName());
            String hashedPassword = PasswordHasher.hashPassword(user.getPassword());
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.setBoolean(3, user.getStatus());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.setInt(7, user.getUserID());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // get all users
    public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM account";
        List<User> users = new ArrayList<User>();
        new DatabaseUtils();
        try {
            Connection connection = DatabaseUtils.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getBoolean("status"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setRole(resultSet.getString("role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return users;
    }

    // delete user
    public boolean deleteUser(int userID) throws SQLException {
        String query = "DELETE FROM account WHERE userID = ?";
        new DatabaseUtils();
        try {
            Connection connection = DatabaseUtils.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // get user by id
    public User selectUser(int userID) throws SQLException {
        String query = "SELECT * FROM account WHERE userID = ?";
        User user = null;
        new DatabaseUtils();
        try {
            Connection connection = DatabaseUtils.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getBoolean("status"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

    // get user by username
    public User selectUserbyname(String username) throws SQLException {
        String query = "SELECT * FROM account WHERE username = ?";
        User user = null;
        new DatabaseUtils();
        try {
            Connection connection = DatabaseUtils.connect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user.setUserID(resultSet.getInt("userID"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setStatus(resultSet.getBoolean("status"));
                user.setFirstName(resultSet.getString("firstname"));
                user.setLastName(resultSet.getString("lastname"));
                user.setRole(resultSet.getString("role"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }

}
