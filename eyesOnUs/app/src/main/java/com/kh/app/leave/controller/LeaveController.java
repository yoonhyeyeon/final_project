package com.kh.app.leave.controller;

import com.kh.app.leave.service.LeaveService;
import com.kh.app.leave.vo.LeaveVo;
import com.kh.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String leaveWrite(LeaveVo vo, HttpSession session) {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String empNo = loginMemberVo.getNo();
        vo.setEmpNo(empNo);

        int leaveWriteResult = service.leaveWrite(vo);
        
        if(leaveWriteResult != 1){
            session.setAttribute("alertMsg", "휴가 신청 실패");
            return "leave/write";
        }
        
        session.setAttribute("alertMsg", "휴가 신청 완료");
        
        return "redirect:/leave/listForWriter";
    } // leaveWrite

    // 휴가 목록 조회 (신청자 입장) (화면)
    @GetMapping("listForWriter")
    public String leaveListForWriter(){
        return "leave/list/listForWriter";
    } // leaveListForWriter

    // 휴가 목록 조회 (승인자 입장) (화면)
    @GetMapping("listForApprover")
    public String leaveListForApprover(){
        return "leave/list/listForApprover";
    } // leaveListForApprover

    // 휴가 상세 조회 (화면)
    @GetMapping("detail")
    public String leaveDetail(LeaveVo leaveVo, Model model){
        // 휴가 상세 조회할 leaveNo 넘겨주기
        model.addAttribute("leaveVo", leaveVo);
        return "leave/detail";
    } // leaveDetail
} // class
