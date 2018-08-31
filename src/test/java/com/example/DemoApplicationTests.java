package com.example;

import com.example.model.Entity;
import com.example.service.EntityService;
import com.example.service.FCategoryService;
import com.example.service.SCategoryService;
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
public class DemoApplicationTests {

    @Autowired
    FCategoryService service2;

    @Autowired
    SCategoryService service3;

    @Autowired
    EntityService service4;

    @Test
    @Rollback(false)
    public void test() {
//        PageInfo<Product> pageinfo = service.selFCategory(3, 1);
//        System.out.print(pageinfo.getList().size()+"11111111111111");

//        PageInfo<FCategory> cc = service2.selFCategory(1,1);
//        List<FCategory> dd = cc.getList();

//        service3.selSCategory(3,1);
        /*FCategory fc = new FCategory();
        fc.setFId(1);
        fc.setFName("dd");
        String c = service2.updateFCategory(fc);*/

        /*SCategory sc = new SCategory();
        sc.setFId(1);
        sc.setSId(4);
        sc.setSName("dd");
        String c = service3.updateSCategory(sc);*/

        Entity en = new Entity();
        en.setEName("dd");
        en.setSId(4);
        en.setEId(3);
        String c = service4.updateEntity(en);
        System.out.print(c);
    }
}
