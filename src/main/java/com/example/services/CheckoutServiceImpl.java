package com.example.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.doa.CartItemRepository;
import com.example.doa.CartRepository;
import com.example.doa.CustomerRepository;
import com.example.entities.Cart;
import com.example.entities.CartItem;
import com.example.entities.Customer;

import static jakarta.persistence.GenerationType.UUID;
import jakarta.transaction.Transactional;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CustomerRepository customerRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository, CartItemRepository cartItemRepository,
            CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        
       if (purchase == null || purchase.getCart() == null || purchase.getCustomer() == null) {
            throw new IllegalArgumentException("Purchase data is incomplete.");
        }
        Cart cart = purchase.getCart();
        String orderTrackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        Set<CartItem> cartItem = purchase.getCarItem();
        cartItem.forEach(item -> cart.add(item));
        Customer customer = purchase.getCustomer();
        customer.add(cart);
        CustomerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }
    }

    

}
