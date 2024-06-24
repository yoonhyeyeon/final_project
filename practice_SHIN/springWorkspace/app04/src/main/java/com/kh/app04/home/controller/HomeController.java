package com.kh.app04.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class HomeController {

    //홈페이지 보여주기
    @GetMapping
    public String m01(){
        return "home";
    }
}
