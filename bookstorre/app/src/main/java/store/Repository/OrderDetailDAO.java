package store.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import store.Model.OrderDetail;
import store.utils.DatabaseUtils;

public class OrderDetailDAO {
    // get all order details

    public List<OrderDetail> getAllOrderDetails() throws SQLException {
        String query = "SELECT odd.id_order_detail, odd.quantity, book.title ,book.price " + //
                "FROM order_detail odd\n" + //
                "JOIN book ON odd.bookID = book.bookID\n" +  //
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

}
