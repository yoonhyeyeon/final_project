package com.kh.app.attendance.controller;

import com.kh.app.attendance.service.AttendanceService;
import com.kh.app.home.vo.HomeVo;
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
@RequestMapping("attendance")
public class AttendanceController {

    private final AttendanceService service;

    @GetMapping("list")
    public String list(HttpSession session){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        return "attendance/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<HomeVo> listData(HttpSession session, String month){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String empNo = loginMemberVo.getNo();

        List<HomeVo> voList = service.list(empNo,month);

        return voList;
    }


}