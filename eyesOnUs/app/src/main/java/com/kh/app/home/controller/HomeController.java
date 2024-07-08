package com.kh.app.home.controller;

import com.kh.app.home.service.CommuteService;
import com.kh.app.home.vo.CommuteVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("home")
@RequiredArgsConstructor
public class HomeController {

    private final CommuteService service;

    @GetMapping
    public String home(){
        return "home";
    }

    // 출근
    @PostMapping("go")
    public HashMap<String, String> write(CommuteVo vo, HttpSession session){
        int result = service.write(vo);

        session.setAttribute("msg" , "출근성공");

        HashMap<String , String> map = new HashMap<>();
        if( result != 1 ){
            map.put("msg", "실패");
        }
        map.put("msg","성공");

        return map;
    }

    // 퇴근
    @PostMapping("quit")
    public HashMap<String, String> quit(CommuteVo vo){
        int result = service.quit(vo);

        HashMap<String, String> map = new HashMap<>();
        if( result != 1 ){
            map.put("msg", "실패");
        }
        map.put("msg", "성공");

        return map;
    }

}
