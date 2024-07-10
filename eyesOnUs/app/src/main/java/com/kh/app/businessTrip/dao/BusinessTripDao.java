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

    // 출장 목록 조회 (신청자 입장) (API)
    public List<BusinessTripVo> getBusinessTripListForWriter(String empNo) {
        List<BusinessTripVo> businessTripVoListForWriter = mapper.getBusinessTripListForWriter(empNo);
        if(businessTripVoListForWriter == null){
            throw new RuntimeException("[B-001] BUSINESS_TRIP LIST FOR WRITER SELECT ERROR");
        }
        return businessTripVoListForWriter;
    } // getBusinessTripListForWriter

    // 출장 승인자 목록 조회 (신청자 입장) (API)
    public List<BusinessTripVo> getBusinessTripApproverListForWriter(String empNo) {
        List<BusinessTripVo> businessTripApproverVoListForWriter = mapper.getBusinessTripApproverListForWriter(empNo);
        if(businessTripApproverVoListForWriter == null){
            throw new RuntimeException("[B-002] BUSINESS_TRIP APPROVER LIST FOR WRITER SELECT ERROR");
        }
        return businessTripApproverVoListForWriter;
    } // getBusinessTripApproverListForWriter

    // 출장 목록 조회 (승인자 입장) (API)
    public List<BusinessTripVo> getBusinessTripListForApprover(String approverNo) {
        List<BusinessTripVo> businessTripVoListForApprover = mapper.getBusinessTripListForApprover(approverNo);
        if(businessTripVoListForApprover == null){
            throw new RuntimeException("[B-003] BUSINESS_TRIP LIST FOR APPROVER SELECT ERROR");
        }
        return businessTripVoListForApprover;
    } // getBusinessTripListForApprover

    // 출장 승인자 목록 조회 (승인자 입장) (API)
    public List<BusinessTripVo> getBusinessTripApproverListForApprover(String approverNo) {
        List<BusinessTripVo> businessTripApproverVoListForApprover = mapper.getBusinessTripApproverListForApprover(approverNo);
        if(businessTripApproverVoListForApprover == null){
            throw new RuntimeException("[B-004] BUSINESS_TRIP APPROVER LIST FOR APPROVER SELECT ERROR");
        }
        return businessTripApproverVoListForApprover;
    } // getBusinessTripApproverListForApprover

    // 출장 상세 조회 (API)
    public BusinessTripVo getBusinessTripDetail(BusinessTripVo businessTripVo) {
        BusinessTripVo businessTripDetailVo = mapper.getBusinessTripDetail(businessTripVo);
        if(businessTripDetailVo == null){
            throw new RuntimeException("[B-005] BUSINESS_TRIP DETAIL SELECT ERROR");
        }
        return businessTripDetailVo;
    } // getBusinessTripDetail

    // 출장 승인자 상세 조회 (API)
    public BusinessTripVo getBusinessTripApproverDetail(BusinessTripVo businessTripVo) {
        BusinessTripVo businessTripApproverDetailVo = mapper.getBusinessTripApproverDetail(businessTripVo);
        if(businessTripApproverDetailVo == null){
            throw new RuntimeException("[B-006] BUSINESS_TRIP APPROVER DETAIL SELECT ERROR");
        }
        return businessTripApproverDetailVo;
    } // getBusinessTripApproverDetail

    // 출장 승인 (API)
    public int updateBusinessTripApprove(BusinessTripVo businessTripVo) {
        int businessTripApproveResult = mapper.updateBusinessTripApprove(businessTripVo);
        if(businessTripApproveResult != 1){
            throw new RuntimeException("[B-007] BUSINESS_TRIP APPROVE UPDATE ERROR");
        }
        return businessTripApproveResult;
    } // updateBusinessTripApprove

    // 프로젝트 목록 조회 (API)
    public List<ProjectVo> getProjectList(String empNo) {
        List<ProjectVo> projectVoList = mapper.getProjectList(empNo);
        if(projectVoList == null){
            throw new RuntimeException("[B-008] PROJECT LIST SELECT ERROR");
        }
        return projectVoList;
    } // getProjectList
} // class
