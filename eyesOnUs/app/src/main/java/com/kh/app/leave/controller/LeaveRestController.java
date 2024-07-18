package com.kh.app.leave.controller;

import com.kh.app.leave.service.LeaveService;
import com.kh.app.leave.vo.LeaveVo;
import com.kh.app.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/leave")
@RequiredArgsConstructor
public class LeaveRestController {

    private final LeaveService service;

    // 휴가 목록 조회 (신청자 입장) (API)
    @GetMapping("listForWriter")
    public Map<String, List> getLeaveListForWriter(LeaveVo leaveVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String empNo = loginMemberVo.getNo();

        Map<String, List> leaveListMapForWriter = service.getLeaveListForWriter(empNo);

        return leaveListMapForWriter;
    } // getLeaveListForWriter

    // 휴가 목록 조회 (승인자 입장) (API)
    @GetMapping("listForApprover")
    public Map<String, List> getLeaveListForApprover(LeaveVo leaveVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String approverNo = loginMemberVo.getNo();

        Map<String, List> leaveListMapForApprover = service.getLeaveListForApprover(approverNo);

        return leaveListMapForApprover;
    } // getLeaveListForApprover

    // 휴가 상세 조회 (API)
    @GetMapping("detail")
    public Map<String, LeaveVo> getLeaveDetail(LeaveVo leaveVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        Map<String, LeaveVo> leaveDetailMap = service.getLeaveDetail(leaveVo, loginMemberVo);

        return leaveDetailMap;
    } // getLeaveDetail

    // 휴가 승인 (API)
    @PutMapping("approve")
    public Map<String, Integer> updateLeaveApprove(LeaveVo leaveVo){
        Map<String, Integer> leaveApproverResultMap = service.updateLeaveApprove(leaveVo);

        return leaveApproverResultMap;
    } // updateLeaveApprove

    // 휴가 타입 목록 (API)
    @GetMapping("leaveTypeList")
    public Map<String, List> getLeaveTypeList(){
        Map<String, List> leaveTypeListMap = service.getLeaveTypeList();

        return leaveTypeListMap;
    } // getLeaveTypeList
} // class
