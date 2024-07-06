package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.LeaderEvalService;
import com.kh.app.evaluation.vo.LeaderEvalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@RequestMapping("leaderEval")
public class LeaderEvalController {

    private final LeaderEvalService service;

    // 작성하기
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

}
