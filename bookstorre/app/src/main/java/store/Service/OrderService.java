package store.Service;

import java.sql.SQLException;
import java.util.List;
import store.Model.Order;
import store.Model.OrderDetail;
import store.Repository.OrderDAO;
import store.Repository.OrderDetailDAO;

public class OrderService {
    private OrderDAO orderDAO;
    private OrderDetailDAO orderDetailDAO;

    public OrderService() {
        this.orderDAO = new OrderDAO();
        this.orderDetailDAO = new OrderDetailDAO();
    }

    public List<Order> getAllOrders() throws SQLException {
        return orderDAO.getAllOrders();
    }

    // delete order
    public void deleteOrder(int orderID) throws SQLException {
        orderDAO.deleteOrder(orderID);
    }

    // select order
    public Order selectOrder(int orderID) throws SQLException {
        return orderDAO.selectOrder(orderID);
    }

    // create order
    public void createOrder(Order order) throws SQLException {
        orderDAO.createOrder(order);
    }

    // ODER Detail
    // ODER Detail
    // ODER Detail

    // get all order details
    public List<OrderDetail> getAllOrderDetails() throws SQLException {
        if (orderDetailDAO == null) {
            throw new IllegalStateException("OrderDetailDAO has not been initialized");
        }
        return orderDetailDAO.getAllOrderDetails();
    }

    // select order detail
    public List<OrderDetail> selectOrderDetailbyID(int orderDetailID) throws SQLException {
        if (orderDetailDAO == null) {
            throw new IllegalStateException("OrderDetailDAO has not been initialized");
        }
        return orderDetailDAO.selectOrderDetailbyID(orderDetailID);
    }

    // ordercatche
    // ordercatche
    // ordercatche
    // ordercatche

    // create orderdetail catche 
    public void createOrderDetailCatche(OrderDetail order) throws SQLException {
        if (orderDetailDAO == null) {
            throw new IllegalStateException("OrderDetailDAO has not been initialized");
        }
        orderDetailDAO.createOrderDetailCatche(order);
    }

    // get List of OrderDetail catche
    public List<OrderDetail> getListOrderDetailCatche() throws SQLException {
        if (orderDetailDAO == null) {
            throw new IllegalStateException("OrderDetailDAO has not been initialized");
        }
        return orderDetailDAO.getListOrderDetailCatche();
    }

    //delete order order catche by  id
    public void deleteOrderDetailCatche(int orderDetailID) throws SQLException {
        if (orderDetailDAO == null) {
            throw new IllegalStateException("OrderDetailDAO has not been initialized");
        }
        orderDetailDAO.deleteOrderDetailCatche(orderDetailID);
    }

    // edit order detail catche
    public void editOrderDetailCatche(OrderDetail order) throws SQLException {
        if (orderDetailDAO == null) {
            throw new IllegalStateException("OrderDetailDAO has not been initialized");
        }
        orderDetailDAO.editOrderDetailCatche(order);
    }
}
