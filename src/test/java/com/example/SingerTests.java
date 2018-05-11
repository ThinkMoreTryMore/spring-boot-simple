package com.example;

import com.example.model.QqSinger;
import com.example.service.SingerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class SingerTests {

    @Autowired
    SingerService service;

    @Test
    @Rollback(true)
    public void contextLoads() {
//        PageInfo<Product> pageinfo = service.selProduct(3, 1);
//        System.out.print(pageinfo.getList().size()+"11111111111111");

        QqSinger singer = new QqSinger();
        service.saveQqSinger(singer);
        service.saveQqSinger(singer);
        service.selQqSinger(1,1);

    }

}
