package store.Model;

public class SheetDetail {
    private String bookTitle;
    private int quantity;
    private double price;
    private String Employee;
    private String Date;

    public SheetDetail(String bookTitle, double price,int quantity, String employee, String date) {
        this.bookTitle = bookTitle;
        this.quantity = quantity;
        this.price = price;
        Employee = employee;
        Date = date;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEmployee() {
        return Employee;
    }

    public void setEmployee(String employee) {
        Employee = employee;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    @Override

    public String toString() {
        return "SheetDetail{" +
                "bookTitle='" + bookTitle + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", Employee='" + Employee + '\'' +
                ", Date='" + Date + '\'' +
                '}';
    }

}
