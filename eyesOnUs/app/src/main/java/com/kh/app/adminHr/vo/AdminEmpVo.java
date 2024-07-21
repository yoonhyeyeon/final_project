package com.kh.app.adminHr.vo;

import lombok.Data;

@Data
public class AdminEmpVo {

    //EMPLOYEE TABLE
    private String no;
    private String deptCode;
    private String divCode;
    private String positionCode;
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
    private String enrollDate;
    private String retireDate;
    private String retireYn;

    //DEPARTMENT TABLE
    private String deptName;

    //DIVISION TABLE
    private String divName;

    //POSITION TABLE
    private String positionName;
}
