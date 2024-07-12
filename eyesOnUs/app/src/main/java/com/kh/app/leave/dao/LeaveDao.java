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

    // 휴가 목록 조회 (신청자 입장) (API)
    public List<LeaveVo> getLeaveListForWriter(String empNo) {
        List<LeaveVo> leaveVoListForWriter = mapper.getLeaveListForWriter(empNo);
        if(leaveVoListForWriter == null){
            throw new RuntimeException("[L-001] LEAVE LIST FOR WRITER SELECT ERROR");
        }
        return leaveVoListForWriter;
    } // getLeaveListForWriter

    // 휴가 승인자 목록 조회 (신청자 입장) (API)
    public List<LeaveVo> getLeaveApproverListForWriter(String empNo) {
        List<LeaveVo> leaveApproverVoListForWriter = mapper.getLeaveApproverListForWriter(empNo);
        if(leaveApproverVoListForWriter == null){
            throw new RuntimeException("[L-002] LEAVE APPROVER LIST FOR WRITER SELECT ERROR");
        }
        return leaveApproverVoListForWriter;
    } // getLeaveApproverListForWriter

    // 휴가 목록 조회 (승인자 입장) (API)
    public List<LeaveVo> getLeaveListForApprover(String approverNo) {
        List<LeaveVo> leaveVoListForApprover = mapper.getLeaveListForApprover(approverNo);
        if(leaveVoListForApprover == null){
            throw new RuntimeException("[L-003] LEAVE LIST FOR APPROVER SELECT ERROR");
        }
        return leaveVoListForApprover;
    } // getLeaveListForApprover

    // 휴가 승인자 목록 조회 (승인자 입장) (API)
    public List<LeaveVo> getLeaveApproverListForApprover(String approverNo) {
        List<LeaveVo> leaveApproverVoListForApprover = mapper.getLeaveApproverListForApprover(approverNo);
        if(leaveApproverVoListForApprover == null){
            throw new RuntimeException("[L-004] LEAVE APPROVER LIST FOR APPROVER SELECT ERROR");
        }
        return leaveApproverVoListForApprover;
    } // getLeaveApproverListForApprover

    // 휴가 상세 조회 (API)
    public LeaveVo getLeaveDetail(LeaveVo leaveVo) {
        LeaveVo leaveDetailVo = mapper.getLeaveDetail(leaveVo);
        if(leaveDetailVo == null){
            throw new RuntimeException("[L-005] LEAVE DETAIL SELECT ERROR");
        }
        return leaveDetailVo;
    } // getLeaveDetail

    // 휴가 승인자 상세 조회 (API)
    public LeaveVo getLeaveApproverDetail(LeaveVo leaveVo) {
        LeaveVo leaveApproverDetailVo = mapper.getLeaveApproverDetail(leaveVo);
        if(leaveApproverDetailVo == null){
            throw new RuntimeException("[L-006] LEAVE APPROVER DETAIL SELECT ERROR");
        }
        return leaveApproverDetailVo;
    } // getLeaveApproverDetail

    // 휴가 승인 (API)
    public int updateLeaveApprove(LeaveVo leaveVo) {
        int leaveApproveResult = mapper.updateLeaveApprove(leaveVo);
        if(leaveApproveResult != 1){
            throw new RuntimeException("[L-007] LEAVE APPROVE UPDATE ERROR");
        }
        return leaveApproveResult;
    } // updateLeaveApprove

    // 휴가 타입 리스트 (API)
    public List<LeaveVo> getLeaveTypeList() {
        List<LeaveVo> leaveTypeVoList = mapper.getLeaveTypeList();
        if(leaveTypeVoList == null){
            throw new RuntimeException("[L-008] LEAVE TYPE LIST SELECT ERROR");
        }
        return leaveTypeVoList;
    } // getLeaveTypeList
} // class
