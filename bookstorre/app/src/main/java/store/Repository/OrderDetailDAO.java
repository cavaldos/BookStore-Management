package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.formdev.flatlaf.util.SystemInfo;

import store.Model.OrderDetail;
import store.utils.DatabaseUtils;

public class OrderDetailDAO {
    // get all order details

    public List<OrderDetail> getAllOrderDetails() throws SQLException {
        String query = "SELECT odd.id_order_detail, odd.quantity, book.title ,book.price " + //
                "FROM order_detail odd\n" + //
                "JOIN book ON odd.bookID = book.bookID\n" + //
                "JOIN orders od ON odd.orderID = od.orderID ";
        List<OrderDetail> orderDetails = new ArrayList<>();
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int idOrderDetail = resultSet.getInt("id_order_detail");
                int quantity = resultSet.getInt("quantity");
                String title = resultSet.getString("title");
                Double price = resultSet.getDouble("price");
                OrderDetail orderDetail = new OrderDetail(idOrderDetail, title, price, quantity);
                orderDetails.add(orderDetail);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orderDetails;

    }

    // select order detail
    public List<OrderDetail> selectOrderDetailbyID(int IDInput) throws SQLException {
        String query = "SELECT odd.id_order_detail, odd.quantity, book.title ,book.price " + //
                "FROM order_detail odd \n" + //
                "JOIN book ON odd.bookID = book.bookID \n" + //
                "JOIN orders od ON odd.orderID = od.orderID \n" + //
                "WHERE od.orderID = ?";
        List<OrderDetail> orderDetail = new ArrayList<>();
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, IDInput);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idOrderDetail = resultSet.getInt("id_order_detail");
                int quantity = resultSet.getInt("quantity");
                String title = resultSet.getString("title");
                Double price = resultSet.getDouble("price");
                OrderDetail order = new OrderDetail(idOrderDetail, title, price, quantity);
                orderDetail.add(order);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orderDetail;
    }

    // create order detail catche
    public void createOrderDetailCatche(OrderDetail orderDetail) throws SQLException {

        String query = "INSERT INTO order_detail_catche (bookID, orderID, quantity) VALUES (?, ?, ?)";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderDetail.getBookID());
            preparedStatement.setInt(2, orderDetail.getOrderID());
            preparedStatement.setInt(3, orderDetail.getQuantity());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // get List of OrderDetail catche
    public List<OrderDetail> getListOrderDetailCatche() throws SQLException {
        String query = "SELECT  oddc.bookID, oddc.quantity, b.title, b.price \n" + //
                "FROM order_detail_catche oddc\n" + //
                "JOIN book b ON oddc.bookID = b.bookID";
        List<OrderDetail> orderDetails = new ArrayList<>();
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                int bookID = resultSet.getInt("bookID");
                int quantity = resultSet.getInt("quantity");
                String title = resultSet.getString("title");
                Double price = resultSet.getDouble("price");
                OrderDetail orderDetail = new OrderDetail(bookID, title, price, quantity);
                orderDetails.add(orderDetail);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orderDetails;
    }

    // delete order detail catche
    public void deleteAllOrderDetailCatche() throws SQLException {
        String query = "DELETE FROM order_detail_catche";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // delete order detail catche by id
    public void deleteOrderDetailCatche(int orderDetailID) throws SQLException {
        String query = "DELETE FROM order_detail_catche WHERE bookID = ?";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderDetailID);
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // edit order detail catche
    public void editOrderDetailCatche(OrderDetail orderDetail) throws SQLException {
        
        String query = "UPDATE order_detail_catche SET quantity = ? WHERE bookID = ?";
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderDetail.getQuantity());
            preparedStatement.setInt(2, orderDetail.getBookID());
            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // get order detail catche by id
    public OrderDetail getOrderDetailCatcheByID(int orderDetailID) throws SQLException {
        String query = "SELECT * FROM order_detail_catche WHERE bookID = ?";
        OrderDetail orderDetail = null;
        new DatabaseUtils();
        try (Connection connection = DatabaseUtils.connect();
                PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, orderDetailID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bookID = resultSet.getInt("bookID");
                int quantity = resultSet.getInt("quantity");
                orderDetail = new OrderDetail(bookID, quantity);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return orderDetail;
    }
}
