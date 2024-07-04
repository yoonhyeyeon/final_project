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

    // ROWNUM
    private String rownum;

    // EMPLOYEE (EMP_NO)
    private String empName;

    // EMPLOYEE (APPROVER_NO)
    private String approverName;
    private String nick;

    // DIVISION (EMP_NO, APPROVER_NO)
    private String divCode;
    private String divName;

    // POSITION (EMP_NO, APPROVER_NO)
    private String positionCode;
    private String positionName;

    // DEPARTMENT (EMP_NO, APPROVER_NO)
    private String deptCode;
    private String deptName;
} // class
