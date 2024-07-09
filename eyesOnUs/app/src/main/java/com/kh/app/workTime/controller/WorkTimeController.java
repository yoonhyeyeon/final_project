package com.kh.app.workTime.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("workTime")
@RequiredArgsConstructor
public class WorkTimeController {


    @GetMapping
    public String workTime(){
        System.out.println("true = " + true);
        return "util/workTime";
    }


}
