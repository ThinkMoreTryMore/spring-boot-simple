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

    public PageInfo<Product> selProduct(int rows, int page) {
        PageHelper.startPage(page, rows);
        Example example = new Example(Product.class);
        Criteria criteria = example.createCriteria();
        List<Product> recordList = productMapper.selectByExample(example);
        PageInfo<Product> pageInfo = new PageInfo<Product>(recordList);
        return pageInfo;
    }

    public int saveProduct(Product product) {
        int i = 0;
        if (product.getId() != null) {
            i = productMapper.updateByPrimaryKey(product);
        } else {
            i = productMapper.insert(product);
        }
        return i;
    }


    @Transactional(rollbackFor = Exception.class)
    public void saveProduct(Product product) {
        int i = 0;
        if (product != null) {
            if (product.getId() != null) {
                i = productMapper.updative(product);
            } else {
                i = productMapper.insert(product);
            }
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void delProduct(Product product) {
        if (product != null && product.getId() != null) {
            int i = 0;
            i = productMapper.deletive(product.getId());
        }
    }

}
