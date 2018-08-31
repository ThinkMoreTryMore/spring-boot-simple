package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Entity {
    private Integer eId;
    private String eName;
    private String eDesc;
    private String createTime;
    private String updateTime;
    private String updateDesc;
    private String deleteFlag;
    private Integer sId;

}