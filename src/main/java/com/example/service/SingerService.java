package com.example.service;

import com.example.dao.QqSingerMapper;
import com.example.model.QqSinger;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

@Service
public class SingerService {
    @Autowired
    QqSingerMapper mapper;

    public PageInfo<QqSinger> selQqSinger(int rows, int page) {
        PageHelper.startPage(page, rows);
        Example example = new Example(QqSinger.class);
        Criteria criteria = example.createCriteria();
        List<QqSinger> recordList = mapper.selectByExample(example);
        PageInfo<QqSinger> pageInfo = new PageInfo<QqSinger>(recordList);
        return pageInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveQqSinger(QqSinger singer) {
        int i = 0;
        if (singer != null) {
            if (singer.getId() != null) {
                i = mapper.updateByPrimaryKeySelective(singer);
                //i = mapper.updative(QqSinger);
            } else {
                i = mapper.insert(singer);
            }
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void delQqSinger(QqSinger singer) {
        if (singer != null && singer.getId() != null) {
            int i = 0;

            //i = mapper.deletive(QqSinger.getId());
        }
    }

}
