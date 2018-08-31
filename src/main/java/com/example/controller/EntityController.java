package com.example.controller;

import com.example.model.Entity;
import com.example.service.EntityService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zp
 * @Description: 实体类
 * @date 2018/8/31 11:03
 */
@RestController
@RequestMapping("/manage/entity")
public class EntityController {

    @Autowired
    private EntityService eService;

    /**
     * @Description: 保存 修改的入口
     * @author zp
     * @date 2018/8/31 11:14
     */
    @RequestMapping("/save")
    public Map<String, Object> saveEntity(Entity entity) {
        Map<String, Object> result = new HashMap<String, Object>();
        String reWord = "";
        try {
            if (entity.getEId() != null) {
                reWord = eService.updateEntity(entity);
            } else {
                reWord = eService.saveEntity(entity);
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

    /**
      * @Description: 查询列表
      * @author zp
      * @date 2018/8/31 11:20
      */
    @RequestMapping("/list")
    public Map<String, Object> selEntity(@RequestBody Map<String, Object> params) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            int rows = (Integer) params.get("rows");
            int page = (Integer) params.get("page");
            String name = (String) params.get("name");
            Entity entity = new Entity();
            entity.setEName(name);
            entity.setEDesc(name);

            PageInfo<Entity> pageInfo = eService.selEntity(rows, page, entity);
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
