package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  private final CustomerRepository repository;

  public CustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  public Customer createCustomer(String name, String email) {
    return repository.save(new Customer(null, name, email));
  }

  public List<Customer> getAllCustomers() {
    return repository.findAll();
  }

  public Customer getCustomerById(UUID id) {
    return repository.findById(id).orElse(null);
  }

  public void deleteCustomer(UUID id) {
    repository.deleteById(id);
  }
}
