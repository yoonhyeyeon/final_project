package com.kh.app.message.vo;

import lombok.Data;

@Data
public class MessageVo {

    private String no;
    private String sender;
    private String receiver;
    private String title;
    private String content;
    private String sendTime;
    private String readYn;
    private String delYn;

    private String senderName;
    private String senderDivName;
    private String senderDeptName;
    private String senderPositionName;

    private String receiverName;
    private String receiverDivName;
    private String receiverDeptName;
    private String receiverPositionName;

}
