package store.Model;

import java.util.Date;
import java.util.List;

public class Order {
    private int orderID;
    private Date date;
    private int customerID;
    private int employeeID;
    private Double totalCost;
    private Double discount;
    private Boolean status;
    private List<OrderDetail> orderDetails;

    public Order(
            int orderID, Date date, int customerID, int employeeID, Double totalCost, Double discount,
            Boolean status) {
        this.orderID = orderID;
        this.date = date;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.totalCost = totalCost;
        this.discount = discount;
        this.status = status;
    }

    public Order(int orderID, Date date, int customerID, int employeeID, Double totalCost, Double discount,
            Boolean status, List<OrderDetail> orderDetails) {
        this.orderID = orderID;
        this.date = date;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.totalCost = totalCost;
        this.discount = discount;
        this.status = status;
        this.orderDetails = orderDetails;
    }

    // Getters
    public int getOrderID() {
        return orderID;
    }

    public Date getDate() {
        return date;
    }

    public int getCustomerID() {
        return customerID;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public Double getDiscount() {
        return discount;
    }

    public Boolean getStatus() {
        return status;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    // Setters

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", date=" + date +
                ", customerID=" + customerID +
                ", employeeID=" + employeeID +
                ", totalCost=" + totalCost +
                ", discount=" + discount +
                ", status='" + status + '\'' +
                ", orderDetails=" + orderDetails +
                "} \n";
    }

}
