package com.example.book.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
    private Date placedAt;
}
