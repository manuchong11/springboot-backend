package com.example.entities;

import java.util.HashSet;
import java.util.Set;

public class Vacation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long countryId;
    
    @Column(name = "package_price")
    private String;

    @Column(name = "party_size")
    private String;

    @Column(name = "status")
    private BigDecimal;

    @Column(name = "order_tracking_number")
    private String;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date;

    @Column(name = "last_update")
    @Deprecated
    private Date;

    private Set<Excursion> excursions = new HashSet<>();

}
