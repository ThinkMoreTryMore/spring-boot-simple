package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

@Setter
@Getter
@Table(name="category_")
public class Category {
    private Integer id;
    private String name;
}