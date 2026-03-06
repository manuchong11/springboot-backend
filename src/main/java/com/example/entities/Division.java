package com.example.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Divisions")
@Getter
@Setter

public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Division_ID")
    private Long divisionId;

    @Column(name = "Division")
    private String division;

    @Column(name = "Create_Date")
    @CreationTimestamp
    private Date createDate;

    @Column(name = "Last_Update")
    @UpdateTimestamp
    private Date lastUpdate;

    @Column(name = "Country_ID")
    private Long countryId;

}
