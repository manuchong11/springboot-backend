package com.example.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.doa.CartItemRepository;
import com.example.doa.CartRepository;
import com.example.doa.CustomerRepository;
import com.example.entities.Cart;
import com.example.entities.CartItem;
import com.example.entities.Customer;
import com.example.entities.StatusType;

import static jakarta.persistence.GenerationType.UUID;
import jakarta.transaction.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    public CheckoutServiceImpl(CustomerRepository customerRepository, CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }
    @Override
    @Transactional
    public PurchaseResponse purchase(Purchase purchase) {
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();
        Customer customer = purchase.getCustomer();
        //Validate customer fields
        if (customer == null || isInvalid(customer.getFirstName()) ||
                isInvalid(customer.getLastName()) || isInvalid(customer.getAddress()) ||
                isInvalid(customer.getPostal_code()) || isInvalid(customer.getPhone())) {
            throw new IllegalArgumentException("Invalid Customer Data");
        }
        //Validate Cart & Items
        if (cart == null || cartItems == null || cartItems.isEmpty()) {
            throw new IllegalArgumentException("The cart is empty. Please add items before checking out.");
        }
        String orderTrackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
        cartItems.forEach(item -> {
            cart.add(item);
            item.setCart(cart);
        });
        customer.add(cart);
        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }
    private boolean isInvalid(String value) {
        return value == null || value.trim().isEmpty();
    }
}