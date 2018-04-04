package com.example.controller;

import com.example.model.Product;
import com.example.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    ProductService service;

    @RequestMapping("/hello")
    public String index() {
        return "hello";
    }

    @PostMapping("/products")
    public Map<String, Object> selProducts(@RequestBody Map<String, Integer> param) {
        Map<String, Object> params = new HashMap<>();
        PageInfo<Product> pageinfo = service.selProduct(param.get("rows"), param.get("page"));

        params.put("list", pageinfo.getList());
        params.put("size", pageinfo.getSize());
        params.put("success",true);
        return params;
    }

    @PostMapping("/saveProduct")
    public Map<String, Object> saveProduct(@RequestBody Product product){
        Map<String, Object> params = new HashMap<>();
        try {
            service.saveProduct(product);
            params.put("success",true);
        }catch (Exception e){
            params.put("success",false);
        }
        params.put("product", product);
        return params;
    }

    @PostMapping("/delProduct")
    public Map<String, Object> delProduct(@RequestBody Product product){
        Map<String, Object> params = new HashMap<>();
        try{
            service.delProduct(product);
            params.put("success",true);
        }catch (Exception e){
            params.put("success",false);
        }
        return params;
    }
}
