package com.example.service;

import com.example.dao.EntityMapper;
import com.example.model.Entity;
import com.example.util.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

@Service
public class EntityService {
    @Autowired
    EntityMapper entityMapper;

    public PageInfo<Entity> selEntity(int rows, int page, Entity entity) {
        PageHelper.startPage(page, rows);
        Example example = new Example(Entity.class);
        Criteria criteria = example.createCriteria();
        // 当存在查询具体名称时
        if (entity.getEName() != null && entity.getEName().length() > 0) {
            criteria.orLike("sName", Utils.getLikes(entity.getEName()));
        }
        if (entity.getEDesc() != null && entity.getEDesc().length() > 0) {
            criteria.orLike("sDesc", Utils.getLikes(entity.getEDesc()));
        }
        List<Entity> recordList = entityMapper.selectByExample(example);
        PageInfo<Entity> pageInfo = new PageInfo<Entity>(recordList);
        return pageInfo;
    }

    public String saveEntity(Entity entity) {
        String re_word = "";
        try {
            int flag = entityMapper.insertSelective(entity);
            if (flag > 0) {
                re_word = "保存成功";
            } else {
                re_word = "保存失败";
            }
        } catch (Exception e) {
            re_word = "因出现错误导致保存失败";
        }
        return re_word;
    }

    public String updateEntity(Entity entity) {
        String re_word = "";
        Example example = new Example(Entity.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("eId", entity.getEId());
        try {
            int flag = entityMapper.updateByExampleSelective(entity, example);
            if (flag > 0) {
                re_word = "修改成功";
            } else {
                re_word = "修改失败";
            }
        } catch (Exception e) {
            re_word = "因出现错误导致保存失败";
        }
        return re_word;
    }
}
