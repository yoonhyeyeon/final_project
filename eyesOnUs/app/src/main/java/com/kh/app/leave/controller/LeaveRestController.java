package com.kh.app.leave.controller;

import com.kh.app.leave.service.LeaveService;
import com.kh.app.leave.vo.LeaveVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/leave")
@RequiredArgsConstructor
public class LeaveRestController {

    private final LeaveService service;

    // 휴가 상세 조회 (API)
    @GetMapping("detail")
    public Map<String, LeaveVo> getLeaveDetail(String leaveNo){
        // 휴가 상세 조회
        LeaveVo leaveDetailVo = service.getLeaveDetail(leaveNo);
        Map<String, LeaveVo> leaveDetailMap = new HashMap<>();
        leaveDetailMap.put("leaveDetailVo", leaveDetailVo);

        // 휴가 승인자 상세 조회
        LeaveVo leaveApproverDetailVo = service.getLeaveApproverDetail(leaveNo);
        leaveDetailMap.put("leaveApproverDetailVo", leaveApproverDetailVo);

        return leaveDetailMap;
    } // getLeaveDetail

    // 휴가 승인자 상세 조회 (API)
    @GetMapping("approverDetail")
    public Map<String, LeaveVo> getLeaveApproverDetail(String leaveNo){
        LeaveVo leaveApproverDetailVo = service.getLeaveApproverDetail(leaveNo);

        Map<String, LeaveVo> leaveApproverDetailMap = new HashMap<>();
        leaveApproverDetailMap.put("leaveApproverDetailVo", leaveApproverDetailVo);

        return leaveApproverDetailMap;
    } // getLeaveApproverDetail

    // 휴가 승인자 목록 조회 (API)
    @GetMapping("approverList")
    public Map<String, List> getLeaveApproverList(String empNo){
        List<LeaveVo> leaveApproverVoList = service.getLeaveApproverList(empNo);

        Map<String, List> leaveApproverListMap = new HashMap<>();
        leaveApproverListMap.put("leaveApproverVoList", leaveApproverVoList);

        return leaveApproverListMap;
    } // getLeaveApproverList

    // 휴가 승인 (API)
    @PutMapping("approve")
    public Map<String, Integer> updateLeaveApprove(LeaveVo leaveVo){
        int leaveApproveResult = service.updateLeaveApprove(leaveVo);

        Map<String, Integer> leaveApproverResultMap = new HashMap<>();
        leaveApproverResultMap.put("leaveApproveResult", leaveApproveResult);

        return leaveApproverResultMap;
    } // updateLeaveApprove

    // 휴가 목록 조회 (동적 쿼리) (API)
    @GetMapping
    public Map<String, List> getLeaveListForAll(LeaveVo leaveVo){
        // 휴가 목록 조회
        List<LeaveVo> leaveVoListForAll = service.getLeaveListForAll(leaveVo);
        Map<String, List> leaveListMapForAll = new HashMap<>();
        leaveListMapForAll.put("leaveVoListForAll", leaveVoListForAll);

        // 휴가 승인자 목록 조회
        String empNo = leaveVo.getEmpNo();
        List<LeaveVo> leaveApproverVoList = service.getLeaveApproverList(empNo);
        leaveListMapForAll.put("leaveApproverVoList", leaveApproverVoList);

        return leaveListMapForAll;
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
