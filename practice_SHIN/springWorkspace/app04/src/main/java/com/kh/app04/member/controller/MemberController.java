package com.kh.app04.member.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("member")
public class MemberController {


    //로그인 요청 화면
    @GetMapping("login")
    public String login(){
        return "member/login";
    }//m1

    //로그인 요청 처리
    @PostMapping("login")
    public String login(@RequestParam Map<String, String> paramMap, HttpSession session){
        System.out.println("paramMap = " + paramMap);
        //홈페이지로 보내기
//        req.setAttribute("msg", "로그인 성공");
//        model.addAttribute("msg", "로그인 성공");
        session.setAttribute("msg","로그인 성공");
        return "redirect:/home";

    }//m2


}//c
