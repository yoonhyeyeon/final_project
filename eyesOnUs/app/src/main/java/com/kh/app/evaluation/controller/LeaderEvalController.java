package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.LeaderEvalService;
import com.kh.app.evaluation.vo.LeaderEvalVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
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
@RequestMapping("leaderEval")
public class LeaderEvalController {

    private final LeaderEvalService service;

    // 작성하기
    @GetMapping("write")
    public String write(EmployeeVo vo, Model model){
        List<EmployeeVo> voList = service.writeList(vo);
        model.addAttribute("voList", voList);

        return "leaderEval/write";
    }

    @PostMapping("write")
    public HashMap<String, String> write(LeaderEvalVo vo){
        int result = service.write(vo);

        HashMap<String , String> map = new HashMap<>();
        map.put("msg", "작성 성공");
        if( result != 1){
            map.put("msg", "작성 실패");
        }

        return map;
    }

    // 목록조회
    @GetMapping("list")
    public String list(){
        return "leaderEval/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<LeaderEvalVo> listData(){
        List<LeaderEvalVo> voList = service.list();
        return voList;
    }

}
