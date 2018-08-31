package com.example.service;

import com.example.dao.FCategoryMapper;
import com.example.model.FCategory;
import com.example.util.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

@Service
public class FCategoryService {
    @Autowired
    FCategoryMapper FCategoryMapper;

    public PageInfo<FCategory> selFCategory(int rows, int page, FCategory fCategory) {
        PageHelper.startPage(page, rows);
        Example example = new Example(FCategory.class);
        Criteria criteria = example.createCriteria();
        // 当存在查询具体名称时
        if (fCategory.getFName() != null && fCategory.getFName().length() > 0) {
            criteria.orLike("fName", Utils.getLikes(fCategory.getFName()));
        }
        if (fCategory.getFDesc() != null && fCategory.getFDesc().length() > 0) {
            criteria.orLike("fDesc", Utils.getLikes(fCategory.getFDesc()));
        }
        List<FCategory> recordList = FCategoryMapper.selectByExample(example);
        PageInfo<FCategory> pageInfo = new PageInfo<FCategory>(recordList);
        return pageInfo;
    }

    public String saveFCategory(FCategory fCategory) {
        String re_word = "";
        try {
            // 设置新增的时间
            fCategory.setCreateTime(Utils.getDate());
            int flag = FCategoryMapper.insertSelective(fCategory);
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

    public String updateFCategory(FCategory fCategory) {
        String re_word = "";
        // 设置更改的时间
        fCategory.setUpdateTime(Utils.getDate());
        Example example = new Example(FCategory.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("fId", fCategory.getFId());
        try {
            int flag = FCategoryMapper.updateByExampleSelective(fCategory, example);
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
