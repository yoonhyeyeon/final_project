package com.kh.app.evaluation.controller;

import com.kh.app.evaluation.service.EvalHomeService;
import com.kh.app.evaluation.vo.EvalHomeVo;
import com.kh.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
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
    public List<EvalHomeVo> evalListData(HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        List<EvalHomeVo> voList = service.list(no);
        return voList;
    }

    // 팀장 평가 목록
    @GetMapping("leaderData")
    @ResponseBody
    public List<EvalHomeVo> leaderData(HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        List<EvalHomeVo> voList = service.leader(no);
        return voList;
    }

    // 팀원 평가 목록
    @GetMapping("memberEvalData")
    @ResponseBody
    public List<EvalHomeVo> memberEvalData(HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        List<EvalHomeVo> voList = service.memberEval(no);
        return voList;
    }

    // 동료 평가 목록
    @GetMapping("colleageData")
    @ResponseBody
    public List<EvalHomeVo> colleageData(HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        List<EvalHomeVo> voList = service.colleage(no);
        return voList;
    }

    // 평가 남은 사원 목록
    @GetMapping("listData2")
    @ResponseBody
    public List<EvalHomeVo> evalListData2(HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String no = loginMemberVo.getNo();

        List<EvalHomeVo> voList = service.list2(no);
        return voList;

    }

}
