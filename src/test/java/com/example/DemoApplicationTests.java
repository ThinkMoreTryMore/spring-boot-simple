package com.example;

import com.example.model.Product;
import com.example.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    ProductService service;

    @Test
    public void contextLoads() {
//        PageInfo<Product> pageinfo = service.selProduct(3, 1);
//        System.out.print(pageinfo.getList().size()+"11111111111111");

        Product pro = new Product();
        pro.setName("电脑88");
//        pro.setId(3);
        service.saveProduct(pro);
//        service.delProduct(pro);
    }

}
