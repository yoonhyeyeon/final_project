package com.kh.app.businessTrip.service;

import com.kh.app.businessTrip.dao.BusinessTripDao;
import com.kh.app.businessTrip.vo.BusinessTripVo;
import com.kh.app.businessTrip.vo.ProjectVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BusinessTripService {

    private final BusinessTripDao dao;

    // 출장 신청
    public int businessTripWrite(BusinessTripVo vo) {
        return dao.businessTripWrite(vo);
    } // businessTripWrite

    // 출장 상세 조회 (API)
    public BusinessTripVo getBusinessTripDetail(String businessTripNo) {
        return dao.getBusinessTripDetail(businessTripNo);
    } // getBusinessTripDetail

    // 출장 승인자 상세 조회 (API)
    public BusinessTripVo getBusinessTripApproverDetail(String businessTripNo) {
        return dao.getBusinessTripApproverDetail(businessTripNo);
    } // getBusinessTripApproverDetail

    // 출장 승인자 목록 조회 (API)
    public List<BusinessTripVo> getBusinessTripApproverList(String empNo) {
        return dao.getBusinessTripApproverList(empNo);
    } // getBusinessTripApproverList

    // 출장 승인 (API)
    public int updateBusinessTripApprove(BusinessTripVo businessTripVo) {
        return dao.updateBusinessTripApprove(businessTripVo);
    } // updateBusinessTripApprove

    // 프로젝트 목록 조회 (API)
    public List<ProjectVo> getProjectList(String empNo) {
        return dao.getProjectList(empNo);
    } // getProjectList

    // 출장 목록 조회 (동적 쿼리) (API)
    public List<BusinessTripVo> getBusinessTripListForAll(BusinessTripVo businessTripVo) {
        return dao.getBusinessTripListForAll(businessTripVo);
    } // getBusinessTripListForAll

//    // 출장 승인 진행 목록 조회 (신청자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripWaitList(String empNo) {
//        return dao.getBusinessTripWaitList(empNo);
//    } // getBusinessTripWaitList
//
//    // 출장 승인 목록 조회 (신청자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripApprovalList(String empNo) {
//        return dao.getBusinessTripApprovalList(empNo);
//    } // getBusinessTripApprovalList
//
//    // 출장 반려 목록 조회 (신청자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripReturnList(String empNo) {
//        return dao.getBusinessTripReturnList(empNo);
//    } // getBusinessTripReturnList
//
//    // 출장 전체 목록 (신청자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripList(String empNo) {
//        return dao.getBusinessTripList(empNo);
//    } // getBusinessTripList
//
//    // 출장 승인 진행 목록 조회 (승인자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripWaitListForApprover(String approverNo) {
//        return dao.getBusinessTripWaitListForApprover(approverNo);
//    } // getBusinessTripWaitListForApprover
//
//    // 출장 승인 목록 조회 (승인자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripApprovalListForApprover(String approverNo) {
//        return dao.getBusinessTripApprovalListForApprover(approverNo);
//    } // getBusinessTripApprovalListForApprover
//
//    // 출장 반려 목록 조회 (승인자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripReturnListForApprover(String approverNo) {
//        return dao.getBusinessTripReturnListForApprover(approverNo);
//    } // getBusinessTripReturnListForApprover
//
//    // 출장 전체 목록 조회 (승인자 입장) (API)
//    public List<BusinessTripVo> getBusinessTripListForApprover(String approverNo) {
//        return dao.getBusinessTripListForApprover(approverNo);
//    } // getBusinessTripListForApprover
} // class
