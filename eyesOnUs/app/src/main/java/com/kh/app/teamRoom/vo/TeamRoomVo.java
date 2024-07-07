package com.kh.app.teamRoom.vo;

import lombok.Data;

@Data
public class TeamRoomVo {

    // projet 테이블의 칼럼
    private int no;           // 'NO' 칼럼
    private int no2;          // 'NO2' 칼럼
    private int stateBNo;     // 'STATE_B_NO' 칼럼
    private int typeNo;       // 'TYPE_NO' 칼럼
    private String startDate; // 'START_DATE' 칼럼
    private String endDate;   // 'END_DATE' 칼럼
    private String modifyDate;// 'MODIFY_DATE' 칼럼
    private String title;     // 'TITLE' 칼럼
    private String content;   // 'CONTENT' 칼럼

    // personal 테이블의 칼럼 (같은 칼럼명으로 복사)
    private int anotherNo;    // 'NO' 칼럼 (두 번째 테이블)
    private int anotherNo2;   // 'NO2' 칼럼 (두 번째 테이블)
    private int anotherStateBNo; // 'STATE_B_NO' 칼럼 (두 번째 테이블)
    private int anotherTypeNo; // 'TYPE_NO' 칼럼 (두 번째 테이블)
    private String anotherStartDate; // 'START_DATE' 칼럼 (두 번째 테이블)
    private String anotherEndDate; // 'END_DATE' 칼럼 (두 번째 테이블)
    private String anotherModifyDate; // 'MODIFY_DATE' 칼럼 (두 번째 테이블)
    private String anotherTitle; // 'TITLE' 칼럼 (두 번째 테이블)
    private String anotherContent; // 'CONTENT' 칼럼 (두 번째 테이블)
}
