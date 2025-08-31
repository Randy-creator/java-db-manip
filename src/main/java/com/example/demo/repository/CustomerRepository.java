package com.example.demo.repository;

import com.example.demo.model.Customer;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
  Customer findByEmail(String Email);
}
