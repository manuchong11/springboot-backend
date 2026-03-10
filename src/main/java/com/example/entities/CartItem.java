package com.example.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class CartItem {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private Vacation vacation;

    private Set<Excursion> excursions = new HashSet<>();

    private Cart cart;

    private Date createDate;

    private Date lastUpdate;

}
