package springDemo.dao;

import springDemo.entity.Customer;

import java.util.List;

public interface CustomerDao {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
