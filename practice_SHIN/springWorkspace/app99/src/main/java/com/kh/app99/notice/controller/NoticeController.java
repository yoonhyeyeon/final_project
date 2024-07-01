package com.kh.app99.notice.controller;

import com.kh.app99.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("notice")
public class NoticeController {

    private final NoticeService service;

    //공지사항 작성 (화면)
    @GetMapping("write")
    public String write(){
        return "notice/write";
    }

    //공지사항 목록조회 (화면)
    @GetMapping("list")
    public String list(){
        return "notice/list";
    }

    //공지사항 상세조회 (화면)
    @GetMapping("detail")
    public String detail(){
        return "notice/detail";
    }

    //공지사항 수정하기 (화면)
    @GetMapping("edit")
    public String edit(){
        return "notice/edit";
    }

}
