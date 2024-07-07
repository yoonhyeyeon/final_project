package com.kh.app.projectwork.vo;

import lombok.Data;

@Data
public class ProjectWorkVo {

    private int no;           // 'NO' 칼럼
    private int no2;          // 'NO2' 칼럼
    private int stateBNo;     // 'STATE_B_NO' 칼럼
    private int typeNo;       // 'TYPE_NO' 칼럼
    private String startDate; // 'START_DATE' 칼럼
    private String endDate;   // 'END_DATE' 칼럼
    private String modifyDate;// 'MODIFY_DATE' 칼럼
    private String title;     // 'TITLE' 칼럼
    private String content;   // 'CONTENT' 칼럼
}
