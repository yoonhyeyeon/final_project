package com.kh.app.test.controller;

import com.kh.app.test.service.TestService;
import com.kh.app.test.vo.TestTeamCalendarVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("test")
public class TestController {

    private final TestService service;

    @GetMapping("home")
    public String testHome(){
        return "test/testIndex";
    }

    @GetMapping("url")
    public String testurl(){
        return "mainUtil/siteMap";
    }

    @GetMapping("main")
    public String testMain(){
        return "test/testMain";
    }

    @GetMapping("person")
    public String testPerson(){
        return "test/testPersonalPage";
    }

    @GetMapping("testHomeCalendar")
    public String homeCalendar(){
        return "test/testHomeCalendar";
    }

    @GetMapping("teamCalendarData")
    @ResponseBody
    public Map<String, Object> teamCalendarData(){
        List<TestTeamCalendarVo> voList = service.teamCalendarData();
        Map<String, Object> result = new HashMap<>();
        result.put("voList", voList);
        System.out.println("voList = " + voList);
        return result;
    }

}
