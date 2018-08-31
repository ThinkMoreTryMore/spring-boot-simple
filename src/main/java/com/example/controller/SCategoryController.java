package com.example.controller;

import com.example.model.SCategory;
import com.example.service.SCategoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zp
 * @Description: 父类的相关操作
 * @date 2018/8/31 10：43
 */
@RestController
@RequestMapping("/manage/sCategory")
public class SCategoryController {

    @Autowired
    private SCategoryService service;

    @RequestMapping("/save")
    public Map<String, Object> savesCategory(SCategory sCategory) {
        Map<String, Object> result = new HashMap<String, Object>();
        String reWord = "";
        try {
            if (sCategory.getFId() != null) {
                reWord = service.updateSCategory(sCategory);
            } else {
                reWord = service.saveSCategory(sCategory);
            }
            result.put("sucess", true);
            result.put("reWord", reWord);
            return result;
        } catch (Exception e) {
            result.put("sucess", false);
            result.put("reWord", "error");
            return result;
        }
    }

    @RequestMapping("/list")
    public Map<String, Object> sCategoryList(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            int rows = (Integer) params.get("rows");
            int page = (Integer) params.get("page");
            String name = (String) params.get("name");
            SCategory sCategory = new SCategory();
            sCategory.setSName(name);
            sCategory.setSDesc(name);

            PageInfo<SCategory> pageInfo = service.selSCategory(rows, page, sCategory);
            result.put("list", pageInfo.getList());
            result.put("success", true);
            return result;
        } catch (Exception e) {
            result.put("success", false);
            result.put("reWord", "error");
            return result;
        }
    }

}
