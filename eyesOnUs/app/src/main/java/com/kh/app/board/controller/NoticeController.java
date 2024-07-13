package com.kh.app.board.controller;

import com.kh.app.board.service.NoticeService;
import com.kh.app.board.vo.NoticeVo;
import com.kh.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService service;

    // 작성하기

    // 목록
    @GetMapping("list")
    public String list(){
        return "board/notice/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<NoticeVo> listData(HttpSession session){

        //MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        //String empNo = loginMemberVo.getNo();

        List<NoticeVo> voList = service.listData();

        return voList;
    }

}
