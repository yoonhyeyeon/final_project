package com.kh.app.member.controller;

import com.kh.app.member.service.MemberService;
import com.kh.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String join(MemberVo vo){
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

    //로그인 요청 처리
    @PostMapping("login")
    public String login(MemberVo vo, HttpSession session){
        MemberVo loginMemberVo = service.login(vo);
        if(loginMemberVo != null) {
            session.setAttribute("loginMemberVo", loginMemberVo);
            return "redirect:/home";
        } else {
            return "/member/login";
        }

    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        session.removeAttribute("loginMemberVo");
        return "redirect:/home";
    }
}//class
