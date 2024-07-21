package com.kh.app.home.controller;

import com.kh.app.adminHr.vo.AdminHrVo;
import com.kh.app.home.service.HomeService;
import com.kh.app.home.vo.HomeVo;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.sign.vo.EmployeeVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService service;

    @GetMapping
    public String home(EmployeeVo vo, Model model,HttpSession session){

        MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");
        AdminHrVo adminHrLoginVo = (AdminHrVo) session.getAttribute("adminHrLoginVo");

        List<EmployeeVo> voList = service.list(vo);

        model.addAttribute("employeeList", voList);

        // 프로필 이미지 경로를 추가
        if (loginMemberVo != null) {
            // 현재 로그인된 사용자 프로필을 리스트에서 찾아서 추가
            for (EmployeeVo employee : voList) {
                if (employee.getNo().equals(loginMemberVo.getNo())) {
                    model.addAttribute("profileImage", employee.getProfile());
                    break;
                }
            }
        }
        return "home";
    }

    // 출근
    @PostMapping("go")
    @ResponseBody
    public HashMap<String, String> write(HomeVo vo, HttpSession session){
        int result = service.write(vo);

        MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");

        HashMap<String , String> map = new HashMap<>();
        if( result != 1 ){
            map.put("msg", "실패");
        }
        map.put("msg","성공");

        return map;
    }

    // 퇴근
    @PostMapping("quit")
    @ResponseBody
    public HashMap<String, String> quit(HomeVo vo, HttpSession session){
        int result = service.quit(vo);

        MemberVo loginMemberVo = (MemberVo)session.getAttribute("loginMemberVo");

        HashMap<String, String> map = new HashMap<>();
        if( result != 1 ){
            map.put("msg", "실패");
        }
        map.put("msg", "성공");

        return map;
    }

    //조직도 화면
    @GetMapping("emp")
    public String list(){ return "homeUtil/emp";}


}//class
