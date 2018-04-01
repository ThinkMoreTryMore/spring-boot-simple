package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Setter
@Getter
@Table(name="product_")
public class Product {
    private Integer id;
    private String name;
    private Float price;
    private Integer categoryId;
    private Integer cid;
    private Integer ver;
}