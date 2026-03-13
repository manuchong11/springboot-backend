package com.example.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "address" )
    private String address;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;
    @Column(name = "customer_first_name")
    private String firstName;
    @Column(name = "customer_last_name")
    private String lastName;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date  last_update;
    @Column(name = "phone")
    private String phone;
    @Column(name = "postal_code")
    private String postal_code;
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

    public void add(Cart cart) {
       if  (carts == null) {
            carts = new HashSet<>();
        }
        carts.add(cart);
        cart.setCustomer(this);
    }
}
