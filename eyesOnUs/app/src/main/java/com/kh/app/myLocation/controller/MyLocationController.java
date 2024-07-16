package com.kh.app.myLocation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("weather")
public class MyLocationController {


    @GetMapping
    public String write(){
        return "mainUtil/weather";
    }

    //카카오 맵
    @GetMapping("kakao")
    public String kakao(){
        return "mainUtil/location";
    }


}//class
