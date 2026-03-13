package com.example.services;

import java.util.Set;

import com.example.entities.Cart;
import com.example.entities.CartItem;
import com.example.entities.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Purchase {

    private Cart cart;
    private Set<CartItem> cartItems;
    private Customer customer;

}
