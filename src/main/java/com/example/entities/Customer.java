package com.example.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;
    @Column(name = "customer_first_name", nullable = false)
    private String firstName;
    @Column(name = "customer_last_name", nullable = false)
    private String lastName;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;
    @Column(name = "phone", nullable = false)
    private String phone;
    @JsonProperty("postal_code")
    @JsonAlias({"postalCode", "postal_code"})
    @Column(name = "postal_code", nullable = false)
    private String postal_code;
    @ManyToOne
    @JoinColumn(name = "division_id", insertable = false, updatable = false)
    private Division division;
    @JsonProperty("division_id")
    @JsonAlias({"divisionId", "division_id", "division"})
    @Column(name = "division_id")
    private Long division_id;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();
    public void add(Cart cart) {
        if (carts == null) {
            carts = new HashSet<>();
        }
        carts.add(cart);
        cart.setCustomer(this);
    }
}

