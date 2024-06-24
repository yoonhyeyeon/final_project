package com.kh.app.personal.controller;

import com.kh.app.personal.service.PersonalService;
import com.kh.app.personal.vo.PersonalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("personal")
@RequiredArgsConstructor
public class PersonalController {

    private final PersonalService service;

    //일정 작성 (화면)
    @GetMapping("write")
    public String write(){return "personal/list";}

    //게시글 작성
    @PostMapping("write")
    @ResponseBody
    public int write(PersonalVo vo){
        int result = service.write(vo);
        return result;
    }

    //게시글 목록조회
    @GetMapping("list")
    @ResponseBody
    public List<PersonalVo> getPersonalList(){
        List<PersonalVo> voList = service.getPersonalList();
        return voList;
    }

}
