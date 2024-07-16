package com.kh.app.sign.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class SignVo {

    // SIGN
    private String no;
    private String empNo;
    private String result;
    private String step;
    private String title;
    private String content;
    private String enrollDate;

    // SIGN_REF
    private List<String> refNo;

    // SIGN_PATH
    private String signNo;
    private List<String> approverNo;
    private String signSeq;
    private String appNo;

    // SIGN_FILE
    private MultipartFile file;
    private String changeName;
    private String originName;
    private String size;
    private String modifyDate;

    // SIGN_COM
    private List<String> comment;

    // EMPLOYEE
    private String empName;
    private String nick;

    // POSITION
    private String positionCode;
    private String positionName;

    // DIVISION
    private String divCode;
    private String divName;

    // DEPARTMENT
    private String deptCode;
    private String deptName;
} // class
