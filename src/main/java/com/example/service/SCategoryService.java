package com.example.service;

import com.example.dao.SCategoryMapper;
import com.example.model.FCategory;
import com.example.model.SCategory;
import com.example.util.Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

@Service
public class SCategoryService {
    @Autowired
    SCategoryMapper sCategoryMapper;

    public PageInfo<SCategory> selSCategory(int rows, int page, SCategory sCategory) {
        PageHelper.startPage(page, rows);
        Example example = new Example(FCategory.class);
        Criteria criteria = example.createCriteria();
        // 当存在查询具体名称时
        if (sCategory.getSName() != null && sCategory.getSName().length() > 0) {
            criteria.orLike("sName", Utils.getLikes(sCategory.getSName()));
        }
        if (sCategory.getSDesc() != null && sCategory.getSDesc().length() > 0) {
            criteria.orLike("sDesc", Utils.getLikes(sCategory.getSDesc()));
        }
        List<SCategory> recordList = sCategoryMapper.selectByExample(example);
        PageInfo<SCategory> pageInfo = new PageInfo<SCategory>(recordList);
        return pageInfo;
    }

    public String saveSCategory(SCategory sCategory) {
        String re_word = "";
        try {
            // 设置新增的时间
            sCategory.setCreateTime(Utils.getDate());
            int flag = sCategoryMapper.insertSelective(sCategory);
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

    public String updateSCategory(SCategory sCategory) {
        String re_word = "";
        Example example = new Example(SCategory.class);
        Criteria criteria = example.createCriteria();
        criteria.andEqualTo("sId", sCategory.getSId());
        try {
            // 设置更改的时间
            sCategory.setUpdateTime(Utils.getDate());
            int flag = sCategoryMapper.updateByExampleSelective(sCategory, example);
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
