package com.kh.app.member.controller;

import com.kh.app.member.member.vo.MemberVo;
import com.kh.app.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;

    //회원가입 화면
    @GetMapping("join")
    public String join(){
        return "member/join";
    }

    //회원가입 기능
    @PostMapping("join")
    public String join(@ModelAttribute MemberVo vo){
        int result = service.join(vo);

        if(result != 1){
            throw new RuntimeException("[M-000] 회원가입 실패");
        }

        return "redirect:/home";
    }

    //로그인 화면
    @GetMapping("login")
    public String login(){
        return "member/login";
    }

    //로그인 기능 구현
    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session){
        System.out.println("vo = " + vo);
        MemberVo loginMemberVo = service.login(vo);

        if(loginMemberVo == null){
            throw new RuntimeException();
        }

        session.setAttribute("loginMemberVo", loginMemberVo);
        return "redirect:/home";
    }

}//class
