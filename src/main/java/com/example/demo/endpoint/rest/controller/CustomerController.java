package com.example.demo.endpoint.rest.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService service;

  public CustomerController(CustomerService service) {
    this.service = service;
  }

  @GetMapping
  public List<Customer> getAll() {
    return service.getAllCustomers();
  }

  @PostMapping
  public Customer create(@RequestBody Customer customer) {
    return service.createCustomer(customer.getName(), customer.getEmail());
  }

  @GetMapping("/{id}")
  public Customer getById(@PathVariable UUID id) {
    return service.getCustomerById(id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable UUID id) {
    service.deleteCustomer(id);
  }
}
