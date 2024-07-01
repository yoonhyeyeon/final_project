package com.kh.app99.notice.controller;

import com.kh.app99.notice.service.NoticeService;
import com.kh.app99.notice.vo.NoticeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notice")
@RequiredArgsConstructor
public class NoticeApiController {

    private final NoticeService service;

    //공지사항 목록조회
    @GetMapping("list")
    public List<NoticeVo> getNoticeList(){
        List<NoticeVo> voList = service.getNoticeList();
        return voList;
    }

    //공지사항 상세조회
    @GetMapping
    public NoticeVo getNoticeByNo(String num){
        NoticeVo vo = service.getNoticeByNo(num);
        return vo;
    }

    //공지사항 작성하기
    @PostMapping
    public String write(NoticeVo vo){
        System.out.println("NoticeApiController.write");
        System.out.println("vo = " + vo);
        int result = service.write(vo);
        return result == 1 ? "write success ~ !" : "write fail...";
    }

    //공지사항 수정하기
    @PutMapping
    public String edit(NoticeVo vo){
        int result = service.edit(vo);
        return result == 1 ? "edit success ~ !" : "edit fail...";
    }

    //공지사항 삭제하기
    @DeleteMapping
    public String delete(String num){
        int result = service.delete(num);
        return result == 1 ? "delete success ~ !" : "delete fail...";
    }

}
