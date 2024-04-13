
package store.Service;

import java.sql.SQLException;
import java.util.List;
import store.Model.Customer;
import store.Repository.CustomerDAO;

public class CustomerService {
    
    private CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    public void insertCustomer(Customer customer) throws SQLException {
        customerDAO.insertCustomer(customer);
    }

    public boolean deleteCustomer(int customerID) throws SQLException {
        return customerDAO.deleteCustomer(customerID);
    }

    public boolean updateCustomer(Customer customer) throws SQLException {
        return customerDAO.updateCustomer(customer);
    }

    public List<Customer> selectAllCustomers() throws SQLException {
        return customerDAO.selectAllCustomers();
    }

    public Customer selectCustomer(int customerID) throws SQLException {
        return customerDAO.selectCustomer(customerID);
    }

}
