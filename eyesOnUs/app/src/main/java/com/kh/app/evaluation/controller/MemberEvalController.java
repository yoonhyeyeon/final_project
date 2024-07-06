package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.MemberEvalService;
import com.kh.app.evaluation.vo.MemberEvalVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("memberEval")
public class MemberEvalController {

    private final MemberEvalService service;

    // 작성하기
    @GetMapping("write")
    public String write(EmployeeVo vo, Model model){
        List<EmployeeVo> voList = service.writeList(vo);
        model.addAttribute("voList", voList);

        return "memberEval/write";
    }

    @PostMapping("write")
    public HashMap<String, String> write(MemberEvalVo vo){
        int result = service.write(vo);

        HashMap<String, String> map = new HashMap<>();
        if( result != 1){
            map.put("msg", "작성 실패");
        }
        map.put("msg", "작성 성공");

        return map;
    }

    // 목록조회
    @GetMapping("list")
    public String list(){
        return "memberEval/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<MemberEvalVo> listData(){
        List<MemberEvalVo> voList = service.list();
        return voList;
    }

}
