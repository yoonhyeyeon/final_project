package com.kh.app.leave.controller;

import com.kh.app.leave.service.LeaveService;
import com.kh.app.leave.vo.LeaveVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("leave")
public class LeaveController {

    private final LeaveService service;

    // 휴가 신청 (화면)
    @GetMapping("write")
    public void leaveWrite(){} // leaveWrite

    // 휴가 신청
    @PostMapping("write")
    public String leaveWrite(LeaveVo vo) {
        int result = service.leaveWrite(vo);
        return "redirect:/home";
    } // leaveWrite

    // 휴가 목록 조회 (화면)
    @GetMapping("list")
    public void leaveList(){} // leaveList

    // 휴가 상세 조회 (화면)
    @GetMapping("detail")
    public void leaveDetail(){} // leaveDetail
} // class
