package com.example.service;

import com.example.dao.QqSpecialMapper;
import com.example.model.QqSpecial;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    QqSpecialMapper mapper;

    public PageInfo<QqSpecial> selSpecial(int rows, int page, QqSpecial record) {
        PageHelper.startPage(page, rows);
        Example example = new Example(QqSpecial.class);
        example.and().andEqualTo("groupId").equals(record.getGroupId());
        Criteria criteria = example.createCriteria();
        List<QqSpecial> recordList = mapper.selectByExample(example);
        PageInfo<QqSpecial> pageInfo = new PageInfo<QqSpecial>(recordList);
        return pageInfo;
    }

    @Transactional(rollbackFor = Exception.class)
    public void saveQqSpecial(QqSpecial special) {
        int i = 0;
        if (special != null) {
            if (special.getId() != null) {
                i = mapper.updateByPrimaryKeySelective(special);
            } else {
                i = mapper.insert(special);
            }
        }

    }

    @Transactional(rollbackFor = Exception.class)
    public void delQqSpecial(QqSpecial special) {
        if (special != null && special.getId() != null) {
            int i = 0;

            //i = mapper.deletive(QqSpecial.getId());
        }
    }

}
