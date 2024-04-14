package store.Repository;

import store.Model.Order;
import store.Model.OrderDetail;
import store.utils.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class OrderDAO {
    // Get all orders
    public List<Order> getAllOrders() throws SQLException {
        String query = "SELECT od.orderID, od.date, cus.username AS customer, acc.username AS employee, od.totalCost, od.discount, od.status\n"
                + //
                "FROM orders od\n" + //
                "JOIN customer cus ON od.customerID = cus.customerID\n" + //
                "JOIN account acc  ON od.employeeID = acc.userID";
        List<Order> orders = new ArrayList<>();
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int orderID = resultSet.getInt("orderID");
                Date date = resultSet.getDate("date");
                String customer = resultSet.getString("customer");
                String employee = resultSet.getString("employee");
                Double totalCost = resultSet.getDouble("totalCost");
                Double discount = resultSet.getDouble("discount");
                Boolean status = resultSet.getBoolean("status");
                Order order = new Order(orderID, date, customer, employee, totalCost, discount, status);
                orders.add(order);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orders;

    }

    // select order()
    public Order selectOrder(int orderID) throws SQLException {
        Order order = null;
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "SELECT od.orderID, od.date, cus.username AS customer, acc.username AS employee, od.totalCost, od.discount, od.status\n"
                                + //
                                "FROM orders od\n" + //
                                "JOIN customer cus ON od.customerID = cus.customerID\n" + //
                                "JOIN account acc  ON od.employeeID = acc.userID\n" + //
                                "WHERE od.orderID = ?")) {
            preparedStatement.setInt(1, orderID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Date date = resultSet.getDate("date");
                String customer = resultSet.getString("customer");
                String employee = resultSet.getString("employee");
                Double totalCost = resultSet.getDouble("totalCost");
                Double discount = resultSet.getDouble("discount");
                Boolean status = resultSet.getBoolean("status");
                order = new Order(orderID, date, customer, employee, totalCost, discount, status);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return order;
    }

    // delete order
    public boolean deleteOrder(int orderID) throws SQLException {
        String query = "DELETE FROM orders WHERE orderID = ?";
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    // create order
    public boolean createOrder(Order order) throws SQLException {
        // --(customerID, employeeID, totalCost, discount, status)
        // CALL create_order(1, 1, 100, 10, 1);
        // if (order.getCustomerID() == null) {
        //     System.out.println(
        // }
        String query = "CALL create_order(?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, order.getCustomerID());
            preparedStatement.setInt(2, order.getEmployeeID());
            preparedStatement.setDouble(3, order.getTotalCost());
            preparedStatement.setDouble(4, order.getDiscount());
            preparedStatement.setBoolean(5, true);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}
