package com.example.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "carts")
@Getter
@Setter
public class Cart {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long ;
    
    @Column(name = "package_price")
    private Long package_price;

    @Column(name = "party_size")
    private int party_size;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "create_date")
    private Date;

    @Column(name = "last_update")
    private;

    @Column(name = "customer_id")
    private;
}
