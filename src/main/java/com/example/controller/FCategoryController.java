package com.example.controller;

import com.example.model.FCategory;
import com.example.service.FCategoryService;
import com.example.util.Utils;
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
 * @date 2018/8/30 21:41
 */
@RestController
@RequestMapping("/manage/fCategory")
public class FCategoryController {

    @Autowired
    private FCategoryService fservice;

    /**
     * @Description: 接收表单形式的提交
     * @author zp
     * @date 2018/8/31 15:47
     */
    @RequestMapping("/save")
    public Map<String, Object> saveFCategory(FCategory fCategory) {
        Map<String, Object> result = new HashMap<String, Object>();
        String reWord = "";
        try {
            if (fCategory.getFId() != null) {
                reWord = fservice.updateFCategory(fCategory);
            } else {
                reWord = fservice.saveFCategory(fCategory);
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

    @RequestMapping("/del")
    public Map<String, Object> delFCategory(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            if (params.get("fId") != null) {

                int fId = (Integer) params.get("fId");
                // 组装对象
                FCategory fcategory = new FCategory();
                fcategory.setFId(fId);
                fcategory.setDeleteFlag(Utils.delete_T);
                String reWord = fservice.updateFCategory(fcategory);

                result.put("sucess", true);
                result.put("reWord", reWord);
                return result;
            }
        } catch (Exception e) {
            result.put("sucess", false);
            result.put("reWord", "error");
        }
        return result;
    }

    @RequestMapping("/list")
    public Map<String, Object> fCategoryList(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            int rows = (Integer) params.get("rows");
            int page = (Integer) params.get("page");
            String name = (String) params.get("name");
            FCategory fCategory = new FCategory();
            fCategory.setFName(name);
            fCategory.setFDesc(name);

            PageInfo<FCategory> pageInfo = fservice.selFCategory(rows, page, fCategory);
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
