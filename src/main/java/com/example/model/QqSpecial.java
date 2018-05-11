package com.example.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Table(name = "qq_special")
public class QqSpecial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String introduce;

    private Float gold;

    @Column(name = "user_id")
    private Integer userId;

    private String img;

    @Column(name = "check_state")
    private Integer checkState;

    @Column(name = "group_id")
    private Integer groupId;

    private Integer singerid;

    @Column(name = "create_date")
    private Date createDate;
}