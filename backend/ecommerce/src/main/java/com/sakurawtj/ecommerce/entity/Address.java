package com.sakurawtj.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Getter;


import lombok.Setter;
@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="street")
    private String street;
    @Column(name="state")
    private String state;
    @Column(name="city")
    private String city;
    @Column(name="country")
    private String country;

    @Column(name="zip_code")
    private String zipcode;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;
}
