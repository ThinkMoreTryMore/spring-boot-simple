package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FCategory {
    private Integer fId;
    private String fName;
    private String fDesc;
    private String createTime;
    private String updateTime;
    private String updateDesc;
    private String deleteFlag;

}