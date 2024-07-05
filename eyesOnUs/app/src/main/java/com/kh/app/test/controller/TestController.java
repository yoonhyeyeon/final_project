package com.kh.app.test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("test")
public class TestController {

    @GetMapping("home")
    public String testHome(){
        return "test/testIndex";
    }

    @GetMapping("url")
    public String testurl(){
        return "test/testUrl";
    }

    @GetMapping("main")
    public String testMain(){
        return "test/testMain";
    }


}
