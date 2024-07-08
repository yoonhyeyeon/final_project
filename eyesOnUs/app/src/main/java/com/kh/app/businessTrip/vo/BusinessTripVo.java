package com.kh.app.businessTrip.vo;

import lombok.Data;

@Data
public class BusinessTripVo {

    // BUSINESS_TRIP
    private String no;
    private String proNo;
    private String empNo;
    private String approverNo;
    private String startDate;
    private String endDate;
    private String reason;
    private String destination;
    private String state;
    private String approveDate;
    private String enrollDate;

    // PROJECT
    private String proCode;
    private String proName;

    // EMPLOYEE
    private String empName;

    // EMPLOYEE
    private String approverName;
    private String nick;

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
