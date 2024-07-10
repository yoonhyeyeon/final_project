package com.kh.app.businessTrip.controller;

import com.kh.app.businessTrip.service.BusinessTripService;
import com.kh.app.businessTrip.vo.BusinessTripVo;
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
@RequestMapping("businessTrip")
public class BusinessTripController {

    private final BusinessTripService service;

    // 출장 신청 (화면)
    @GetMapping("write")
    public void businessTripWrite(){} // businessTripWrite

    // 출장 신청
    @PostMapping("write")
    public String businessTripWrite(BusinessTripVo vo, HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String empNo = loginMemberVo.getNo();
        vo.setEmpNo(empNo);

        int businessTripWriteResult = service.businessTripWrite(vo);
        return "businessTrip/list/listForWriter";
    } // businessTripWrite

    // 출장 목록 조회 (신청자 입장) (화면)
    @GetMapping("listForWriter")
    public String businessTripListForWriter(){
        return "businessTrip/list/listForWriter";
    } // businessTripListForWriter

    // 출장 목록 조회 (승인자 입장) (화면)
    @GetMapping("listForApprover")
    public String businessTripListForApprover(){
        return "businessTrip/list/listForApprover";
    } // businessTripListForApprover

    // 출장 상세 조회 (화면)
    @GetMapping("detail")
    public String businessTripDetail(BusinessTripVo businessTripVo, Model model){
        model.addAttribute("businessTripVo", businessTripVo);
        return "businessTrip/detail";
    } // businessTripDetail
} // class
