package com.example.entities;

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
