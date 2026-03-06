package com.example.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "countries")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Cart_ID")
    private Long countryId;
    
    @Column(name = "Package_Price")
    private String country;

    @Column(name = "Party_Size")
    private Date createDate;

    @Column(name = "Status")
    private Date lastUpdate;

    @Column(name = "Order_Tracking_Number")





}
