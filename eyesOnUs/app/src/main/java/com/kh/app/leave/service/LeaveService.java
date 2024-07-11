package com.kh.app.leave.service;

import com.kh.app.leave.dao.LeaveDao;
import com.kh.app.leave.vo.LeaveVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public List<LeaveVo> getLeaveListForWriter(String empNo) {
        return dao.getLeaveListForWriter(empNo);
    } // getLeaveListForWriter

    // 휴가 승인자 목록 조회 (신청자 입장) (API)
    public List<LeaveVo> getLeaveApproverListForWriter(String empNo) {
        return dao.getLeaveApproverListForWriter(empNo);
    } // getLeaveApproverListForWriter

    // 휴가 목록 조회 (승인자 입장) (API)
    public List<LeaveVo> getLeaveListForApprover(String approverNo) {
        return dao.getLeaveListForApprover(approverNo);
    } // getLeaveListForApprover

    // 휴가 승인자 목록 조회 (승인자 입장) (API)
    public List<LeaveVo> getLeaveApproverListForApprover(String approverNo) {
        return dao.getLeaveApproverListForApprover(approverNo);
    } // getLeaveApproverListForApprover

    // 휴가 상세 조회 (API)
    public LeaveVo getLeaveDetail(LeaveVo leaveVo) {
        return dao.getLeaveDetail(leaveVo);
    } // getLeaveDetail

    // 휴가 승인자 상세 조회 (API)
    public LeaveVo getLeaveApproverDetail(LeaveVo leaveVo) {
        return dao.getLeaveApproverDetail(leaveVo);
    } // getLeaveApproverDetail

    // 휴가 승인 (API)
    public int updateLeaveApprove(LeaveVo leaveVo) {
        return dao.updateLeaveApprove(leaveVo);
    } // updateLeaveApprove

    // 휴가 타입 리스트 (API)
    public List<LeaveVo> getLeaveTypeList() {
        return dao.getLeaveTypeList();
    } // getLeaveTypeList
} // class
