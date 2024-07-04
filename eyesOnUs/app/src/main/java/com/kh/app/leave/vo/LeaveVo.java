package com.kh.eyes.leave.vo;

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

    // ROWNUM
    private String rownum;

    // EMPLOYEE (EMP_NO)
    private String empName;

    // EMPLOYEE (APPROVER_NO)
    private String approverName;
    private String nick;

    // LEAVE_TYPE (TYPE_NO)
    private String leaveType;
    private String leaveName;

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
