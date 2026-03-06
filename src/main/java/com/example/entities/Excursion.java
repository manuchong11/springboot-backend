package com.example.entities;

public class Excursion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long countryId;
    
    @Column(name = "package_price")
    private String country;

    @Column(name = "party_size")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "status")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name = "order_tracking_number")
    private;

    @Column(name = "create_date")
    private;

    @Column(name = "last_update")
    private;

}
