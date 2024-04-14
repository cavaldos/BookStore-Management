package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.Customer;
import store.utils.DatabaseUtils;

public class CustomerDAO {
    // insert customer
    public void insertCustomer(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (username, firstname, lastname) VALUES (?, ?, ?)";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, customer.getUserName());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // delete customer
    public boolean deleteCustomer(int customerID) throws SQLException {
        String sql = "DELETE FROM customer WHERE customerID = ?";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customerID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // update customer
    public boolean updateCustomer(Customer customer) throws SQLException {
        String sql = "UPDATE customer SET username = ?, firstname = ?, lastname = ? WHERE customerID = ?";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, customer.getUserName());
            preparedStatement.setString(2, customer.getFirstName());
            preparedStatement.setString(3, customer.getLastName());
            preparedStatement.setInt(4, customer.getCustomerID());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // select all customers
    public List<Customer> selectAllCustomers() throws SQLException {
        String sql = "SELECT * FROM customer";
        List<Customer> customers = new ArrayList<>();
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int customerID = rs.getInt("customerID");
                String username = rs.getString("username");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                customers.add(new Customer(customerID, username, firstname, lastname));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customers;
    }

    // select customer by id
    public Customer selectCustomer(int customerID) throws SQLException {
        String sql = "SELECT * FROM customer WHERE customerID = ?";
        Customer customer = null;
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, customerID);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                customer = new Customer(customerID, username, firstname, lastname);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customer;
    }
    // get customer by username
    public Customer getCustomerByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM customer WHERE username = ?";
        Customer customer = null;
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int customerID = rs.getInt("customerID");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                customer = new Customer(customerID, username, firstname, lastname);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
