package com.example.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.entities.Cart;

@CrossOrigin("http://localhost:4200")
public interface CartRepository extends JpaRepository<Cart, Long> {

}
