package com.kh.app.sign.vo;

import lombok.Data;

@Data
public class EmployeeVo {

    // EMPLOYEE
    private String no;

    private String state;
    private String salaryCode;
    private String rank;
    private String salary;
    private String bonus;
    private String id;
    private String pwd;
    private String nick;
    private String name;
    private String phone;
    private String address;
    private String profile;
    private String enrollDate;
    private String retireDate;
    private String retireYn;

    // DIVISION
    private String divCode;
    private String divName;

    // POSITION
    private String positionCode;
    private String positionName;

    // DEPARTMENT
    private String deptCode;
    private String deptName;
} // class
