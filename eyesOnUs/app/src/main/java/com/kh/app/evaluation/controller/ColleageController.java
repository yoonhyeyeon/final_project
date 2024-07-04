package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.ColleageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("colleage")
public class ColleageController {

    private final ColleageService service;
//
//    @PostMapping("write")
//    public void write(){
//        int result = service.write();
//    }

}
