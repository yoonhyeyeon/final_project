package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.ColleageEvalService;
import com.kh.app.evaluation.vo.ColleageEvalVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@Controller
@RequiredArgsConstructor
@RequestMapping("colleageEval")
public class ColleageEvalController {

    private final ColleageEvalService service;

    // 작성하기
    @GetMapping("write")
    public String write(EmployeeVo vo, Model model){
        List<EmployeeVo> voList = service.writeList(vo);
        model.addAttribute("voList", voList);

        return "colleageEval/write";
    }

    @PostMapping("write")
    public HashMap<String, String> write(ColleageEvalVo vo){
        int result = service.write(vo);

        HashMap<String, String> map = new HashMap<>();
        map.put("msg" , "작성 성공");
        if( result != 1){
            map.put("msg", "작성 실패");
        }
        return map;
    }

    // 목록
    @GetMapping("list")
    public String list(){
        return "colleageEval/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<ColleageEvalVo> listData(){
        List<ColleageEvalVo> voList = service.list();
        return voList;
    }
}
