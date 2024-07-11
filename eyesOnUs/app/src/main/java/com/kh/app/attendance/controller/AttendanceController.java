package com.kh.app.attendance.controller;

import com.kh.app.attendance.service.AttendanceService;
import com.kh.app.home.vo.CommuteVo;
import com.kh.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<CommuteVo> listData(HttpSession session, String month){

        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String empNo = loginMemberVo.getNo();

        List<CommuteVo> voList = service.list(empNo,month);

        return voList;
    }


}