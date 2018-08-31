package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SCategory {
    /**
     * 子类编号
     */
    private Integer sId;

    /**
     * 子类名称
     */
    private String sName;

    /**
     * 子类详情
     */
    private String sDesc;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 修改详情
     */
    private String updateDesc;

    /**
     * T/F 删除标记
     */
    private String deleteFlag;

    /**
     * 父类编号
     */
    private Integer fId;

}