package com.kh.eyes.leave.service;

import com.kh.eyes.leave.dao.LeaveDao;
import com.kh.eyes.leave.vo.LeaveVo;
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

    // 휴가 상세 조회 (API)
    public LeaveVo getLeaveDetail(String leaveNo) {
        return dao.getLeaveDetail(leaveNo);
    } // getLeaveDetail

    // 휴가 승인자 상세 조회 (API)
    public LeaveVo getLeaveApproverDetail(String leaveNo) {
        return dao.getLeaveApproverDetail(leaveNo);
    } // getLeaveApproverDetail

    // 휴가 승인자 목록 조회 (API)
    public List<LeaveVo> getLeaveApproverList(String empNo) {
        return dao.getLeaveApproverList(empNo);
    } // getLeaveApproverList

    // 휴가 승인 (API)
    public int updateLeaveApprove(LeaveVo leaveVo) {
        return dao.updateLeaveApprove(leaveVo);
    } // updateLeaveApprove

    // 휴가 목록 조회 (동적 쿼리) (API)
    public List<LeaveVo> getLeaveListForAll(LeaveVo leaveVo) {
        return dao.getLeaveListForAll(leaveVo);
    } // getLeaveListForAll

//    // 휴가 승인 대기 목록 조회 (신청자 입장) (API)
//    public List<LeaveVo> getLeaveWaitList(String empNo) {
//        return dao.getLeaveWaitList(empNo);
//    } // getLeaveWaitList
//
//    // 휴가 승인 목록 조회 (신청자 입장) (API)
//    public List<LeaveVo> getLeaveApprovalList(String empNo) {
//        return dao.getLeaveApprovalList(empNo);
//    } // getLeaveApprovalList
//
//    // 휴가 반려 목록 조회 (신청자 입장) (API)
//    public List<LeaveVo> getLeaveReturnList(String empNo) {
//        return dao.getLeaveReturnList(empNo);
//    } // getLeaveReturnList
//
//    // 휴가 전체 목록 조회 (신청자 입장) (API)
//    public List<LeaveVo> getLeaveList(String empNo) {
//        return dao.getLeaveList(empNo);
//    } // getLeaveList
//
//    // 휴가 승인 대기 목록 조회 (승인자 입장) (API)
//    public List<LeaveVo> getLeaveWaitListForApprover(String approverNo) {
//        return dao.getLeaveWaitListForApprover(approverNo);
//    } // getLeaveWaitListForApprover
//
//    // 휴가 승인 목록 조회 (승인자 입장) (API)
//    public List<LeaveVo> getLeaveApprovalListForApprover(String approverNo) {
//        return dao.getLeaveApprovalListForApprover(approverNo);
//    } // getLeaveApprovalListForApprover
//
//    // 휴가 반려 목록 조회 (승인자 입장) (API)
//    public List<LeaveVo> getLeaveReturnListForApprover(String approverNo) {
//        return dao.getLeaveReturnListForApprover(approverNo);
//    } // getLeaveReturnListForApprover
//
//    // 휴가 전체 목록 조회 (승인자 입장) (API)
//    public List<LeaveVo> getLeaveListForApprover(String approverNo) {
//        return dao.getLeaveListForApprover(approverNo);
//    } // getLeaveListForApprover
} // class
