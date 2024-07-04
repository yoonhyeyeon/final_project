package com.kh.app.leave.dao;

import com.kh.app.leave.mapper.LeaveMapper;
import com.kh.app.leave.vo.LeaveVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LeaveDao {

    private final LeaveMapper mapper;

    // 휴가 신청
    public int leaveWrite(LeaveVo vo) {
        int result = mapper.leaveWrite(vo);
        if(result != 1){
            throw new RuntimeException("[L-000] LEAVE INSERT ERROR");
        }
        return result;
    } // leaveWrite

    // 휴가 상세 조회 (API)
    public LeaveVo getLeaveDetail(String leaveNo) {
        LeaveVo leaveDetailVo = mapper.getLeaveDetail(leaveNo);
        if(leaveDetailVo == null){
            throw new RuntimeException("[L-005] LEAVE DETAIL SELECT ERROR");
        }
        return leaveDetailVo;
    } // getLeaveDetail

    // 휴가 승인자 상세 조회 (API)
    public LeaveVo getLeaveApproverDetail(String leaveNo) {
        LeaveVo leaveApproverVo = mapper.getLeaveApproverDetail(leaveNo);
        if(leaveApproverVo == null){
            throw new RuntimeException("[L-006] LEAVE APPROVER DETAIL SELECT ERROR");
        }
        return leaveApproverVo;
    } // getLeaveApproverDetail

    // 휴가 승인자 목록 조회 (API)
    public List<LeaveVo> getLeaveApproverList(String empNo) {
        List<LeaveVo> leaveApproverVoList = mapper.getLeaveApproverList(empNo);
        if(leaveApproverVoList == null){
            throw new RuntimeException("[L-007] LEAVE APPROVER LIST SELECT ERROR");
        }
        return leaveApproverVoList;
    } // getLeaveApproverVoList

    // 휴가 승인 (API)
    public int updateLeaveApprove(LeaveVo leaveVo) {
        int leaveApproveResult = mapper.updateLeaveApprove(leaveVo);
        if(leaveApproveResult != 1){
            throw new RuntimeException("[L-008] LEAVE STATE UPDATE ERROR");
        }
        return leaveApproveResult;
    } // updateLeaveApprove

    // 휴가 목록 조회 (동적 쿼리) (API)
    public List<LeaveVo> getLeaveListForAll(LeaveVo leaveVo) {
        List<LeaveVo> leaveVoListForAll = mapper.getLeaveListForAll(leaveVo);
        if(leaveVoListForAll == null){
            throw new RuntimeException("[L-013] LEAVE LIST FOR ALL SELECT ERROR");
        }
        return leaveVoListForAll;
    } // getLeaveListForAll

//    // 휴가 승인 대기 목록 조회 (신청자 입장) (API)
//    public List<LeaveVo> getLeaveWaitList(String empNo) {
//        List<LeaveVo> leaveWaitVoList = mapper.getLeaveWaitList(empNo);
//        if(leaveWaitVoList == null){
//            throw new RuntimeException("[L-001] LEAVE WAIT LIST SELECT ERROR");
//        }
//        return leaveWaitVoList;
//    } // getLeaveWaitList
//
//    // 휴가 승인 목록 조회 (신청자 입장) (API)
//    public List<LeaveVo> getLeaveApprovalList(String empNo) {
//        List<LeaveVo> leaveApprovalVoList = mapper.getLeaveApprovalList(empNo);
//        if(leaveApprovalVoList == null){
//            throw new RuntimeException("[L-002] LEAVE APPROVAL LIST SELECT ERROR");
//        }
//        return leaveApprovalVoList;
//    } // getLeaveApprovalList
//
//    // 휴가 반려 목록 조회 (신청자 입장) (API)
//    public List<LeaveVo> getLeaveReturnList(String empNo) {
//        List<LeaveVo> leaveReturnVoList = mapper.getLeaveReturnList(empNo);
//        if(leaveReturnVoList == null){
//            throw new RuntimeException("[L-003] LEAVE RETURN LIST SELECT ERROR");
//        }
//        return leaveReturnVoList;
//    } // getLeaveReturnList
//
//    // 휴가 전체 목록 조회 (신청자 입장) (API)
//    public List<LeaveVo> getLeaveList(String empNo) {
//        List<LeaveVo> leaveVoList = mapper.getLeaveList(empNo);
//        if(leaveVoList == null){
//            throw new RuntimeException("[L-004] LEAVE LIST SELECT ERROR");
//        }
//        return leaveVoList;
//    } // getLeaveList
//
//    // 휴가 승인 대기 목록 조회 (승인자 입장) (API)
//    public List<LeaveVo> getLeaveWaitListForApprover(String approverNo) {
//        List<LeaveVo> leaveWaitVoListForApprover = mapper.getLeaveWaitListForApprover(approverNo);
//        if(leaveWaitVoListForApprover == null){
//            throw new RuntimeException("[L-009] LEAVE WAIT LIST FOR APPROVER SELECT ERROR");
//        }
//        return leaveWaitVoListForApprover;
//    } // getLeaveWaitListForApprover
//
//    // 휴가 승인 목록 조회 (승인자 입장) (API)
//    public List<LeaveVo> getLeaveApprovalListForApprover(String approverNo) {
//        List<LeaveVo> leaveApproverVoListForApprover = mapper.getLeaveApprovalListForApprover(approverNo);
//        if(leaveApproverVoListForApprover == null){
//            throw new RuntimeException("[L-010] LEAVE APPROVAL LIST FOR APPROVER SELECT ERROR");
//        }
//        return leaveApproverVoListForApprover;
//    } // getLeaveApprovalListForApprover
//
//    // 휴가 반려 목록 조회 (승인자 입장) (API)
//    public List<LeaveVo> getLeaveReturnListForApprover(String approverNo) {
//        List<LeaveVo> leaveReturnVoListForApprover = mapper.getLeaveReturnListForApprover(approverNo);
//        if(leaveReturnVoListForApprover == null){
//            throw new RuntimeException("[L-011] LEAVE RETURN LIST FOR APPROVER SELECT ERROR");
//        }
//        return leaveReturnVoListForApprover;
//    } // getLeaveReturnListForApprover
//
//    // 휴가 전체 목록 조회 (승인자 입장) (API)
//    public List<LeaveVo> getLeaveListForApprover(String approverNo) {
//        List<LeaveVo> leaveVoListForApprover = mapper.getLeaveListForApprover(approverNo);
//        if(leaveVoListForApprover == null){
//            throw new RuntimeException("[L-012] LEAVE LIST FOR APPROVER SELECT ERROR");
//        }
//        return leaveVoListForApprover;
//    } // getLeaveListForApprover
} // class
