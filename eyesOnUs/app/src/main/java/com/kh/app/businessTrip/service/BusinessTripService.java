package com.kh.app.businessTrip.service;

import com.kh.app.businessTrip.dao.BusinessTripDao;
import com.kh.app.businessTrip.vo.BusinessTripVo;
import com.kh.app.businessTrip.vo.ProjectVo;
import com.kh.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class BusinessTripService {

    private final BusinessTripDao dao;

    // 출장 신청
    public int businessTripWrite(BusinessTripVo vo) {
        return dao.businessTripWrite(vo);
    } // businessTripWrite

    // 출장 목록 조회 (신청자 입장) (API)
    public List<BusinessTripVo> getBusinessTripListForWriter(String empNo) {
        return dao.getBusinessTripListForWriter(empNo);
    } // getBusinessTripListForWriter

    // 출장 승인자 목록 조회 (신청자 입장) (API)
    public List<BusinessTripVo> getBusinessTripApproverListForWriter(String empNo) {
        return dao.getBusinessTripApproverListForWriter(empNo);
    } // getBusinessTripApproverListForWriter

    // 출장 목록 조회 (결재자 입장) (API)
    public List<BusinessTripVo> getBusinessTripListForApprover(String approverNo) {
        return dao.getBusinessTripListForApprover(approverNo);
    } // getBusinessTripListForApprover

    // 출장 승인자 목록 조회 (결재자 입장) (API)
    public List<BusinessTripVo> getBusinessTripApproverListForApprover(String approverNo) {
        return dao.getBusinessTripApproverListForApprover(approverNo);
    } // getBusinessTripApproverListForApprover

    // 출장 상세 조회 (API)
    public BusinessTripVo getBusinessTripDetail(String businessTripNo) {
        return dao.getBusinessTripDetail(businessTripNo);
    } // getBusinessTripDetail

    // 출장 승인자 상세 조회 (API)
    public BusinessTripVo getBusinessTripApproverDetail(String businessTripNo) {
        return dao.getBusinessTripApproverDetail(businessTripNo);
    } // getBusinessTripApproverDetail

    // 출장 승인 (API)
    public int updateBusinessTripApprove(BusinessTripVo businessTripVo) {
        return dao.updateBusinessTripApprove(businessTripVo);
    } // updateBusinessTripApprove

    // 프로젝트 목록 조회 (API)
    public List<ProjectVo> getProjectList(String empNo) {
        return dao.getProjectList(empNo);
    } // getProjectList
} // class
