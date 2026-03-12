package com.example.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.Customer;

@CrossOrigin("http://localhost:4200")
public interface customerRepository extends JpaRepository<Customer, Long> {

}
