package store.Model;

public class Customer {
    private int customerID;
    private String username;
    private String firstname;
    private String lastname;

    public Customer(int customerID, String username, String firstname, String lastname) {
        this.customerID = customerID;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Customer(String username, String firstname, String lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getUserName() {
        return username;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override

    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
