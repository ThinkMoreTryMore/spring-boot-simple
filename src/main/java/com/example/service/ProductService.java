package com.example.service;

import com.example.dao.ProductMapper;
import com.example.model.Product;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    public PageInfo<Product> selProduct(int rows, int page){
        PageHelper.startPage(page, rows);
        Example example = new Example(Product.class);
        Criteria criteria = example.createCriteria();
        List<Product> recordList = productMapper.selectByExample(example);
        PageInfo<Product> pageInfo = new PageInfo<Product>(recordList);
        return pageInfo;
    }

}
