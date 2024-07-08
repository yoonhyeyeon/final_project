package com.kh.app.businessTrip.dao;

import com.kh.app.businessTrip.mapper.BusinessTripMapper;
import com.kh.app.businessTrip.vo.BusinessTripVo;
import com.kh.app.businessTrip.vo.ProjectVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BusinessTripDao {

    private final BusinessTripMapper mapper;

    // 출장 신청
    public int businessTripWrite(BusinessTripVo vo) {
        int writeResult = mapper.businessTripWrite(vo);
        if(writeResult != 1){
            throw new RuntimeException("[B-000] BUSINESS_TRIP INSERT ERROR");
        }
        return writeResult;
    } // businessTripWrite

    // 출장 상세 조회 (API)
    public BusinessTripVo getBusinessTripDetail(String businessTripNo) {
        BusinessTripVo businessTripDetailVo = mapper.getBusinessTripDetail(businessTripNo);
        if(businessTripDetailVo == null){
            throw new RuntimeException("[B-005] BUSINESS_TRIP DETAIL SELECT ERROR");
        }
        return businessTripDetailVo;
    } // getBusinessTripDetail

    // 출장 승인자 상세 조회 (API)
    public BusinessTripVo getBusinessTripApproverDetail(String businessTripNo) {
        BusinessTripVo businessTripApproverDetailVo = mapper.getBusinessTripApproverDetail(businessTripNo);
        if(businessTripApproverDetailVo == null){
            throw new RuntimeException("[B-006] BUSINESS_TRIP APPROVER DETAIL SELECT ERROR");
        }
        return businessTripApproverDetailVo;
    } // getBusinessTripApproverDetail

    // 출장 승인자 목록 조회 (API)
    public List<BusinessTripVo> getBusinessTripApproverList(String empNo) {
        List<BusinessTripVo> businessTripApproverVoList = mapper.getBusinessTripApproverList(empNo);
        if(businessTripApproverVoList == null){
            throw new RuntimeException("[B-007] BUSINESS_TRIP APPROVER LIST SELECT ERROR");
        }
        return businessTripApproverVoList;
    } // getBusinessTripApproverList

    // 출장 승인 (API)
    public int updateBusinessTripApprove(BusinessTripVo businessTripVo) {
        int businessTripApproveResult = mapper.updateBusinessTripApprove(businessTripVo);
        if(businessTripApproveResult != 1){
            throw new RuntimeException("[B-008] BUSINESS_TRIP STATE UPDATE ERROR");
        }
        return businessTripApproveResult;
    } // updateBusinessTripApprove

    // 프로젝트 목록 조회 (API)
    public List<ProjectVo> getProjectList(String empNo) {
        List<ProjectVo> projectVoList = mapper.getProjectList(empNo);
        if(projectVoList == null){
            throw new RuntimeException("[B-009] PROJECT LIST SELECT ERROR");
        }
        return projectVoList;
    } // getProjectList

    // 출장 목록 조회 (동적 쿼리) (API)
    public List<BusinessTripVo> getBusinessTripListForAll(BusinessTripVo businessTripVo) {
        List<BusinessTripVo> businessTripVoListForAll = mapper.getBusinessTripListForAll(businessTripVo);
        if(businessTripVoListForAll == null){
            throw new RuntimeException("[B-014] BUSINESS_TRIP LIST FOR ALL SELECT ERROR");
        }
        return businessTripVoListForAll;
    } // getBusinessTripListForAll

//    // 출장 승인 진행 목록 조회 (신청자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripWaitList(String empNo) {
//        List<BusinessTripVo> businessTripWaitVoList = mapper.getBusinessTripWaitList(empNo);
//        if(businessTripWaitVoList == null){
//            throw new RuntimeException("[B-001] BUSINESS_TRIP WAIT LIST SELECT ERROR");
//        }
//        return businessTripWaitVoList;
//    } // getBusinessTripWaitList
//
//    // 출장 승인 목록 조회 (신청자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripApprovalList(String empNo) {
//        List<BusinessTripVo> businessTripApprovalVoList = mapper.getBusinessTripApprovalList(empNo);
//        if(businessTripApprovalVoList == null){
//            throw new RuntimeException("[B-002] BUSINESS_TRIP APPROVAL LIST SELECT ERROR");
//        }
//        return businessTripApprovalVoList;
//    } // getBusinessTripApprovalList
//
//    // 출장 반려 목록 조회 (신청자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripReturnList(String empNo) {
//        List<BusinessTripVo> businessTripReturnVoList = mapper.getBusinessTripReturnList(empNo);
//        if(businessTripReturnVoList == null){
//            throw new RuntimeException("[B-003] BUSINESS_TRIP RETURN LIST SELECT ERROR");
//        }
//        return businessTripReturnVoList;
//    } // getBusinessTripReturnList
//
//    // 출장 전체 목록 조회 (신청자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripList(String empNo) {
//        List<BusinessTripVo> businessTripVoList = mapper.getBusinessTripList(empNo);
//        if(businessTripVoList == null){
//            throw new RuntimeException("[B-004] BUSINESS_TRIP LIST SELECT ERROR");
//        }
//        return businessTripVoList;
//    } // getBusinessTripList
//
//    // 출장 승인 진행 목록 조회 (승인자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripWaitListForApprover(String approverNo) {
//        List<BusinessTripVo> businessTripWaitVoListForApprover = mapper.getBusinessTripWaitListForApprover(approverNo);
//        if(businessTripWaitVoListForApprover == null){
//            throw new RuntimeException("[B-010] BUSINESS_TRIP WAIT LIST FOR APPROVER SELECT ERROR");
//        }
//        return businessTripWaitVoListForApprover;
//    } // getBusinessTripWaitListForApprover
//
//    // 출장 승인 목록 조회 (승인자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripApprovalListForApprover(String approverNo) {
//        List<BusinessTripVo> businessTripApprovalVoListForApprover = mapper.getBusinessTripApprovalListForApprover(approverNo);
//        if(businessTripApprovalVoListForApprover == null){
//            throw new RuntimeException("[B-011] BUSINESS_TRIP APPROVAL LIST FOR APPROVER SELECT ERROR");
//        }
//        return businessTripApprovalVoListForApprover;
//    } // getBusinessTripApprovalListForApprover
//
//    // 출장 반려 목록 조회 (승인자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripReturnListForApprover(String approverNo) {
//        List<BusinessTripVo> businessTripReturnVoListForApprover = mapper.getBusinessTripReturnListForApprover(approverNo);
//        if(businessTripReturnVoListForApprover == null){
//            throw new RuntimeException("[B-012] BUSINESS_TRIP RETURN LIST FOR APPROVER SELECT ERROR");
//        }
//        return businessTripReturnVoListForApprover;
//    } // getBusinessTripReturnListForApprover
//
//    // 출장 전체 목록 조회 (승인자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripListForApprover(String approverNo) {
//        List<BusinessTripVo> businessTripVoListForApprover = mapper.getBusinessTripListForApprover(approverNo);
//        if(businessTripVoListForApprover == null){
//            throw new RuntimeException("[B-013] BUSINESS_TRIP LIST FOR APPROVER SELECT ERROR");
//        }
//        return businessTripVoListForApprover;
//    } // getBusinessTripListForApprover
} // class
