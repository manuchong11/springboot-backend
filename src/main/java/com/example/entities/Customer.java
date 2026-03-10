package com.example.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Customers")
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_ID")
    private Long customerId;

    @Column(name = "First_Name" )
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Address")
    private String address;

    @Column(name = "Postal_Code")
    private String postalCode;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Create_Date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "Last_Update")
    @UpdateTimestamp
    private Date lastUpdate;

   
    @ManyToOne
    @JoinColumn(name = "division_id")
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Cart> carts = new HashSet<>();

}
