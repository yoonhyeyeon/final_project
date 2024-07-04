package com.kh.eyes.leave.controller;

import com.kh.eyes.leave.service.LeaveService;
import com.kh.eyes.leave.vo.LeaveVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/leave")
@RequiredArgsConstructor
public class LeaveRestController {

    private final LeaveService service;

    // 휴가 상세 조회 (API)
    @GetMapping("detail")
    public LeaveVo getLeaveDetail(String leaveNo){
        LeaveVo leaveDetailVo = service.getLeaveDetail(leaveNo);
        return leaveDetailVo;
    } // getLeaveDetail

    // 휴가 승인자 상세 조회 (API)
    @GetMapping("approverDetail")
    public LeaveVo getLeaveApproverDetail(String leaveNo){
        LeaveVo leaveApproverVo = service.getLeaveApproverDetail(leaveNo);
        return leaveApproverVo;
    } // getLeaveApproverDetail

    // 휴가 승인자 목록 조회 (API)
    @GetMapping("approverList")
    public List<LeaveVo> getLeaveApproverList(String empNo){
        List<LeaveVo> leaveApproverVoList = service.getLeaveApproverList(empNo);
        return leaveApproverVoList;
    } // getLeaveApproverList

    // 휴가 승인 (API)
    @PutMapping("approve")
    public int updateLeaveApprove(LeaveVo leaveVo){
        int leaveApproveResult = service.updateLeaveApprove(leaveVo);
        return leaveApproveResult;
    } // updateLeaveApprove

    // 휴가 목록 조회 (동적 쿼리) (API)
    @GetMapping
    public List<LeaveVo> getLeaveListForAll(LeaveVo leaveVo){
        List<LeaveVo> leaveVoListForAll = service.getLeaveListForAll(leaveVo);
        return leaveVoListForAll;
    } // getLeaveListForAll

//    // 휴가 승인 진행 목록 조회 (신청자 입장) (API)
//    @GetMapping("wait")
//    public List<LeaveVo> getLeaveWaitList(String empNo){
//        List<LeaveVo> leaveWaitVoList = service.getLeaveWaitList(empNo);
//        return leaveWaitVoList;
//    } // getLeaveWaitList
//
//    // 휴가 승인 목록 조회 (신청자 입장) (API)
//    @GetMapping("approval")
//    public List<LeaveVo> getLeaveApprovalList(String empNo){
//        List<LeaveVo> leaveApprovalVoList = service.getLeaveApprovalList(empNo);
//        return leaveApprovalVoList;
//    } // getLeaveApprovalList
//
//    // 휴가 반려 목록 조회 (신청자 입장) (API)
//    @GetMapping("return")
//    public List<LeaveVo> getLeaveReturnList(String empNo){
//        List<LeaveVo> leaveReturnVoList = service.getLeaveReturnList(empNo);
//        return leaveReturnVoList;
//    } // getLeaveReturnList
//
//    // 휴가 전체 목록 조회 (신청자 입장) (API)
//    @GetMapping("list")
//    public List<LeaveVo> getLeaveVoList(String empNo){
//        List<LeaveVo> leaveVoList = service.getLeaveList(empNo);
//        return leaveVoList;
//    } // getLeaveList
//
//    // 휴가 승인 진행 목록 조회 (승인자 입장) (API)
//    @GetMapping("approver/wait")
//    public List<LeaveVo> getLeaveWaitListForApprover(String approverNo){
//        List<LeaveVo> leaveWaitVoListForApprover = service.getLeaveWaitListForApprover(approverNo);
//        return leaveWaitVoListForApprover;
//    } // getLeaveWaitListForApprover
//
//    // 휴가 승인 목록 조회 (승인자 입장) (API)
//    @GetMapping("approver/approval")
//    public List<LeaveVo> getLeaveApprovalListForApprover(String approverNo){
//        List<LeaveVo> leaveApprovalVoListForApprover = service.getLeaveApprovalListForApprover(approverNo);
//        return leaveApprovalVoListForApprover;
//    } // getLeaveApprovalListForApprover
//
//    // 휴가 반려 목록 조회 (승인자 입장) (API)
//    @GetMapping("approver/return")
//    public List<LeaveVo> getLeaveReturnListForApprover(String approverNo){
//        List<LeaveVo> leaveReturnVoListForApprover = service.getLeaveReturnListForApprover(approverNo);
//        return leaveReturnVoListForApprover;
//    } // getLeaveReturnListForApprover
//
//    // 휴가 전체 목록 조회 (승인자 입장) (API)
//    @GetMapping("approver/list")
//    public List<LeaveVo> getLeaveListForApprover(String approverNo){
//        List<LeaveVo> leaveVoListForApprover = service.getLeaveListForApprover(approverNo);
//        return leaveVoListForApprover;
//    } // getLeaveListForApprover
} // class
