package com.kh.app.leave.controller;

import com.kh.app.businessTrip.vo.BusinessTripVo;
import com.kh.app.leave.service.LeaveService;
import com.kh.app.leave.vo.LeaveVo;
import com.kh.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

        // 휴가 목록 조회 (신청자 입장) (API)
        List<LeaveVo> leaveVoListForWriter = service.getLeaveListForWriter(empNo);
        Map<String, List> leaveListMapForWriter = new HashMap<>();
        leaveListMapForWriter.put("leaveVoListForWriter", leaveVoListForWriter);

        // 휴가 승인자 목록 조회 (신청자 입장) (API)
        List<LeaveVo> leaveApproverVoListForWriter = service.getLeaveApproverListForWriter(empNo);
        leaveListMapForWriter.put("leaveApproverVoListForWriter", leaveApproverVoListForWriter);

        return leaveListMapForWriter;
    } // getLeaveListForWriter

    // 휴가 목록 조회 (승인자 입장) (API)
    @GetMapping("listForApprover")
    public Map<String, List> getLeaveListForApprover(LeaveVo leaveVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String approverNo = loginMemberVo.getNo();

        // 휴가 목록 조회 (승인자 입장) (API)
        List<LeaveVo> leaveVoListForApprover = service.getLeaveListForApprover(approverNo);
        Map<String, List> leaveListMapForApprover = new HashMap<>();
        leaveListMapForApprover.put("leaveVoListForApprover", leaveVoListForApprover);

        // 휴가 승인자 목록 조회 (승인자 입장) (API)
        List<LeaveVo> leaveApproverVoListForApprover = service.getLeaveApproverListForApprover(approverNo);
        leaveListMapForApprover.put("leaveApproverVoListForApprover", leaveApproverVoListForApprover);

        return leaveListMapForApprover;
    } // getLeaveListForApprover

    // 휴가 상세 조회 (API)
    @GetMapping("detail")
    public Map<String, LeaveVo> getLeaveDetail(LeaveVo leaveVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        // 휴가 상세 조회 (API)
        LeaveVo leaveDetailVo = service.getLeaveDetail(leaveVo);
        Map<String, LeaveVo> leaveDetailMap = new HashMap<>();
        leaveDetailMap.put("leaveDetailVo", leaveDetailVo);

        // 휴가 승인자 상세 조회 (API)
        LeaveVo leaveApproverDetailVo = service.getLeaveApproverDetail(leaveVo);
        leaveDetailMap.put("leaveApproverDetailVo", leaveApproverDetailVo);

        // 승인, 반려 버튼 판단용 로그인 사원 번호
        LeaveVo vo = new LeaveVo();
        vo.setEmpNo(loginMemberVo.getNo());
        leaveDetailMap.put("vo", vo);

        return leaveDetailMap;
    } // getLeaveDetail

    // 휴가 승인 (API)
    @PutMapping("approve")
    public Map<String, Integer> updateLeaveApprove(LeaveVo leaveVo){
        int leaveApproveResult = service.updateLeaveApprove(leaveVo);

        Map<String, Integer> leaveApproverResultMap = new HashMap<>();
        leaveApproverResultMap.put("leaveApproveResult", leaveApproveResult);

        return leaveApproverResultMap;
    } // updateLeaveApprove

    // 휴가 타입 리스트 (API)
    @GetMapping("leaveTypeList")
    public Map<String, List> getLeaveTypeList(){
        List<LeaveVo> leaveTypeVoList = service.getLeaveTypeList();

        Map<String, List> leaveTypeListMap = new HashMap<>();
        leaveTypeListMap.put("leaveTypeVoList", leaveTypeVoList);

        return leaveTypeListMap;
    } // getLeaveTypeList
} // class
