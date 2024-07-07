package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.EvalHomeService;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("evaluation")
public class EvalHomeController {

    private final EvalHomeService service;

    @GetMapping("list")
    public String evalList(){
        return "";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<EmployeeVo> evalListData(){
        List<EmployeeVo> voList = service.list();
        return voList;
    }

}
