package com.kh.app04.board.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class BoardVo {

    private  String no;
    private  String title;
    private  String content;
    private List<MultipartFile> attachmentList;


}
