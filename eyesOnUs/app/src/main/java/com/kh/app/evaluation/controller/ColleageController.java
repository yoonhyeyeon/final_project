package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.ColleageService;
import com.kh.app.evaluation.vo.ColleageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@CrossOrigin
@Controller
@RequiredArgsConstructor
@RequestMapping("colleage")
public class ColleageController {

    private final ColleageService service;

    // 작성하기
    @GetMapping("write")
    public String write(){
        return " write";
    }

    @PostMapping("write")
    public HashMap<String, String> write(ColleageVo vo){
        int result = service.write(vo);

        HashMap<String, String> map = new HashMap<>();
        map.put("msg" , "작성 성공");
        if( result != 1){
            map.put("msg", "작성 실패");
        }
        return map;
    }

}
