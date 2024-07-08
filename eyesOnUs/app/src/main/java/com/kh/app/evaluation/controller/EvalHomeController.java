package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.EvalHomeService;
import com.kh.app.evaluation.vo.EvalHomeVo;
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
        return "evaluation/list";
    }

    // 평가해야될 모든 사원 목록
    @GetMapping("listData")
    @ResponseBody
    public List<EvalHomeVo> evalListData(){
        List<EvalHomeVo> voList = service.list();
        return voList;
    }

    // 팀장 평가 목록
    @GetMapping("leaderData")
    @ResponseBody
    public List<EvalHomeVo> leaderData(){
        List<EvalHomeVo> voList = service.leader();
        return voList;
    }

    // 팀원 평가 목록
    @GetMapping("memberEvalData")
    @ResponseBody
    public List<EvalHomeVo> memberEvalData(){
        List<EvalHomeVo> voList = service.memberEval();
        return voList;
    }

    // 동료 평가 목록
    @GetMapping("colleageData")
    @ResponseBody
    public List<EvalHomeVo> colleageData(){
        List<EvalHomeVo> voList = service.colleage();
        return voList;
    }

}
