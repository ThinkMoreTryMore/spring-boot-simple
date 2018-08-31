package com.example.model;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Product {
    private Integer id;
    private String name;
    private Float price;
    private Integer categoryId;
    private Integer cid;
    private Integer ver;
}