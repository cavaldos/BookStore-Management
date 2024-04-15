package com.raven.data;

/**
 *
 * @author RAVEN
 */
public class ModelData {

    

    public String getTime() {
        return time;
    }

    public void setTime(String month) {
        this.time = month;
    }

    public double getBook() {
        return book;
    }

    public void setBook(double book) {
        this.book = book;
    }

    public double getCategory() {
        return category;
    }

    public void setCategory(double category) {
        this.category = category;
    }

    public double getCustomer() {
        return customer;
    }

    public void setCustomer(double customer) {
        this.customer = customer;
    }
 public double getEmployee() {
        return employee;
    }

    public void setEmployee(double employee) {
        this.employee = employee;
    }
    public ModelData(String time, double book, double category, double customer, double employee) {
        this.time = time;
        this.book = book;
        this.category = category;
        this.customer = customer;
          this.employee = employee;
    }

    public ModelData() {
    }

    private String time;
    private double book;
    private double category;
    private double customer;
    private double employee;
}
