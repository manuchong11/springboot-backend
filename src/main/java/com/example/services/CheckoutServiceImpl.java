package com.example.services;

import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private CustomerRepository customerRepository;
    private CartItemRepository cartItemRepository;
    private CartRepository cartRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartItemRepository cartItemRepository,
            CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        // TODO Auto-generated method stub
        return null;
    }

}
