package com.example.dao;

import com.example.model.Product;
import com.example.util.MyMapper;

public interface ProductMapper extends MyMapper<Product> {
    int updative(Product product);
    int deletive(Integer id);
}