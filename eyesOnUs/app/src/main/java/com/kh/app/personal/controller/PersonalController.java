package com.kh.app.personal.controller;

import com.kh.app.personal.service.PersonalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("personal")
@RequiredArgsConstructor
public class PersonalController {

    private final PersonalService service;

    //기타일정 작성하기 화면
    @GetMapping("write")
    public String write(){
        return "personal/write";
    }



    //기타일정 목록조회 화면
    @GetMapping("list")
    public String list(){
        return "personal/list";
    }



    //기타일정 상세조회 화면
    @GetMapping("detail")
    public String detail(){
        return "personal/detail";
    }

    //기타일정 삭제하기 화면
    @GetMapping("delete")
    public String delete(){
        return "personal/delete";
    }

    //기타일정 삭제하기 화면
    @GetMapping
    public String teamRoom(){
        return "personal/personalShow";
    }

}
