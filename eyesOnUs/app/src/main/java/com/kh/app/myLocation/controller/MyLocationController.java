package com.kh.app.myLocation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("location")
public class MyLocationController {


    @GetMapping
    public String write(){
        return "mainUtil/location";
    }


}//class