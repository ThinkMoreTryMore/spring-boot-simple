package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    ProductService service;

    @RequestMapping("/hello")
    public String index(){
        return "hello";
    }

    @RequestMapping("/products")
    public String selProducts(){
        PageInfo<Product> pageinfo = service.selProduct(3, 1);
        return pageinfo.getList().size()+"";
    }
}
