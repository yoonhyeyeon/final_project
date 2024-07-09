package com.kh.app.leave.vo;

import lombok.Data;

@Data
public class LeaveVo {

    // LEAVE
    private String no;
    private String typeNo;
    private String empNo;
    private String approverNo;
    private String startDate;
    private String endDate;
    private String reason;
    private String state;
    private String approveDate;
    private String enrollDate;

    // EMPLOYEE
    private String empName;

    // EMPLOYEE
    private String approverName;
    private String nick;

    // LEAVE_TYPE
    private String leaveType;
    private String leaveName;

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
