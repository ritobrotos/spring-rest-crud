package springDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springDemo.entity.Customer;
import springDemo.exception.CustomerNotFoundException;
import springDemo.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {
        Customer customer = service.getCustomer(customerId);
        if(customer == null) {
            throw new CustomerNotFoundException("Customer Id not found " + customerId);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        service.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        service.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {
        Customer customer = service.getCustomer(customerId);
        if(customer == null) {
            throw new CustomerNotFoundException("Customer not found with id: " + customerId);
        }
        service.deleteCustomer(customerId);
        return "Deleted Customer id: " + customerId;
    }
}
