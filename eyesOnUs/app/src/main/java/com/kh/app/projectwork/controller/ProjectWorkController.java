package com.kh.app.projectwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("projectWork")
public class ProjectWorkController {

    //조회 화면
    @GetMapping("list")
    public String list(){
        return "projectWork/list";

    }

    //작성 화면
    @GetMapping("write")
    public String write(){
        return "projectWork/write";
    }

    //팀룸 화면
    @GetMapping
    public String teamRoom(){
        return "projectWork/projectShow";
    }

}//class
