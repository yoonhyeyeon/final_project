package com.kh.app.leave.service;

import com.kh.app.leave.dao.LeaveDao;
import com.kh.app.leave.vo.LeaveVo;
import com.kh.app.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class LeaveService {

    private final LeaveDao dao;

    // 휴가 신청
    public int leaveWrite(LeaveVo vo) {
        return dao.leaveWrite(vo);
    } // leaveWrite

    // 휴가 목록 조회 (신청자 입장) (API)
    public Map<String, List> getLeaveListForWriter(String empNo) {
        // 휴가 목록 조회 (신청자 입장) (API)
        List<LeaveVo> leaveVoListForWriter = dao.getLeaveListForWriter(empNo);

        // 휴가 승인자 목록 조회 (신청자 입장) (API)
        List<LeaveVo> leaveApproverVoListForWriter = dao.getLeaveApproverListForWriter(empNo);

        // 휴가 목록, 승인자 묶기
        Map<String, List> leaveListMapForWriter = new HashMap<>();
        leaveListMapForWriter.put("leaveVoListForWriter", leaveVoListForWriter);
        leaveListMapForWriter.put("leaveApproverVoListForWriter", leaveApproverVoListForWriter);

        return leaveListMapForWriter;
    } // getLeaveListForWriter

    // 휴가 목록 조회 (승인자 입장) (API)
    public Map<String, List> getLeaveListForApprover(String approverNo) {
        // 휴가 목록 조회 (승인자 입장) (API)
        List<LeaveVo> leaveVoListForApprover = dao.getLeaveListForApprover(approverNo);

        // 휴가 승인자 목록 조회 (승인자 입장) (API)
        List<LeaveVo> leaveApproverVoListForApprover = dao.getLeaveApproverListForApprover(approverNo);

        // 휴가 목록, 승인자 묶기
        Map<String, List> leaveListMapForApprover = new HashMap<>();
        leaveListMapForApprover.put("leaveVoListForApprover", leaveVoListForApprover);
        leaveListMapForApprover.put("leaveApproverVoListForApprover", leaveApproverVoListForApprover);

        return leaveListMapForApprover;
    } // getLeaveListForApprover

    // 휴가 상세 조회 (API)
    public Map<String, LeaveVo> getLeaveDetail(LeaveVo leaveVo, MemberVo loginMemberVo) {
        // 휴가 상세 조회 (API)
        LeaveVo leaveDetailVo = dao.getLeaveDetail(leaveVo);

        // 휴가 승인자 상세 조회 (API)
        LeaveVo leaveApproverDetailVo = dao.getLeaveApproverDetail(leaveVo);

        // 승인, 반려 버튼 판단용 로그인 사원 번호
        LeaveVo vo = new LeaveVo();
        vo.setEmpNo(loginMemberVo.getNo());

        // 휴가 상세, 승인자, 로그인 사원 번호 묶기
        Map<String, LeaveVo> leaveDetailMap = new HashMap<>();
        leaveDetailMap.put("leaveDetailVo", leaveDetailVo);
        leaveDetailMap.put("leaveApproverDetailVo", leaveApproverDetailVo);
        leaveDetailMap.put("vo", vo);

        return leaveDetailMap;
    } // getLeaveDetail

    // 휴가 승인 (API)
    public Map<String, Integer> updateLeaveApprove(LeaveVo leaveVo) {
        // 휴가 승인 (API)
        int leaveApproveResult = dao.updateLeaveApprove(leaveVo);

        // 휴가 승인 정보 묶기
        Map<String, Integer> leaveApproverResultMap = new HashMap<>();
        leaveApproverResultMap.put("leaveApproveResult", leaveApproveResult);

        return leaveApproverResultMap;
    } // updateLeaveApprove

    // 휴가 타입 목록 (API)
    public Map<String, List> getLeaveTypeList() {
        List<LeaveVo> leaveTypeVoList = dao.getLeaveTypeList();

        // 휴가 타입 목록 묶기
        Map<String, List> leaveTypeListMap = new HashMap<>();
        leaveTypeListMap.put("leaveTypeVoList", leaveTypeVoList);
        
        return leaveTypeListMap;
    } // getLeaveTypeList
} // class
