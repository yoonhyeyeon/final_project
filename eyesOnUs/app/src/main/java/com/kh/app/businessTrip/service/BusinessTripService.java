package com.kh.app.businessTrip.service;

import com.kh.app.businessTrip.dao.BusinessTripDao;
import com.kh.app.businessTrip.vo.BusinessTripVo;
import com.kh.app.businessTrip.vo.ProjectVo;
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
public class BusinessTripService {

    private final BusinessTripDao dao;

    // 출장 신청
    public int businessTripWrite(BusinessTripVo vo) {
        return dao.businessTripWrite(vo);
    } // businessTripWrite

    // 출장 목록 조회 (신청자 입장) (API)
    public Map<String, List> getBusinessTripListForWriter(String empNo) {
        // 출장 목록 조회 (신청자 입장) (API)
        List<BusinessTripVo> businessTripVoListForWriter = dao.getBusinessTripListForWriter(empNo);

        // 출장 승인자 목록 조회 (신청자 입장) (API)
        List<BusinessTripVo> businessTripApproverVoListForWriter = dao.getBusinessTripApproverListForWriter(empNo);

        // 출장 목록, 승인자 묶기
        Map<String, List> businessTripListMapForWriter = new HashMap<>();
        businessTripListMapForWriter.put("businessTripVoListForWriter", businessTripVoListForWriter);
        businessTripListMapForWriter.put("businessTripApproverVoListForWriter", businessTripApproverVoListForWriter);

        return businessTripListMapForWriter;
    } // getBusinessTripListForWriter

    // 출장 목록 조회 (승인자 입장) (API)
    public Map<String, List> getBusinessTripListForApprover(String approverNo) {
        // 출장 목록 조회 (승인자 입장) (API)
        List<BusinessTripVo> businessTripVoListForApprover = dao.getBusinessTripListForApprover(approverNo);

        // 출장 승인자 목록 조회 (승인자 입장) (API)
        List<BusinessTripVo> businessTripApproverVoListForApprover = dao.getBusinessTripApproverListForApprover(approverNo);

        // 출장 목록, 승인자 묶기
        Map<String, List> businessTripListMapForApprover = new HashMap<>();
        businessTripListMapForApprover.put("businessTripVoListForApprover", businessTripVoListForApprover);
        businessTripListMapForApprover.put("businessTripApproverVoListForApprover", businessTripApproverVoListForApprover);

        return businessTripListMapForApprover;
    } // getBusinessTripListForApprover

    // 출장 상세 조회 (API)
    public Map<String, BusinessTripVo> getBusinessTripDetail(BusinessTripVo businessTripVo, MemberVo loginMemberVo) {
        // 출장 상세 조회 (API)
        BusinessTripVo businessTripDetailVo = dao.getBusinessTripDetail(businessTripVo);

        // 출장 승인자 상세 조회 (API)
        BusinessTripVo businessTripApproverDetailVo = dao.getBusinessTripApproverDetail(businessTripVo);

        // 승인, 반려 버튼 판단용 로그인 사원 번호
        BusinessTripVo vo = new BusinessTripVo();
        vo.setEmpNo(loginMemberVo.getNo());

        // 출장 상세, 승인자, 로그인 사원 번호 묶기
        Map<String, BusinessTripVo> businessTripDetailMap = new HashMap<>();
        businessTripDetailMap.put("businessTripDetailVo", businessTripDetailVo);
        businessTripDetailMap.put("businessTripApproverDetailVo", businessTripApproverDetailVo);
        businessTripDetailMap.put("vo", vo);

        return businessTripDetailMap;
    } // getBusinessTripDetail

    // 출장 승인 (API)
    public Map<String, Integer> updateBusinessTripApprove(BusinessTripVo businessTripVo) {
        // 출장 승인 (API)
        int businessTripApproveResult = dao.updateBusinessTripApprove(businessTripVo);

        // 출장 승인 정보 묶기
        Map<String, Integer> businessTripApproveResultMap = new HashMap<>();
        businessTripApproveResultMap.put("businessTripApproveResult", businessTripApproveResult);

        return businessTripApproveResultMap;
    } // updateBusinessTripApprove

    // 프로젝트 목록 조회 (API)
    public Map<String, List> getProjectList(String empNo) {
        // 프로젝트 목록 조회 (API)
        List<ProjectVo> projectVoList = dao.getProjectList(empNo);

        // 프로젝트 목록 묶기
        Map<String, List> projectListMap = new HashMap<>();
        projectListMap.put("projectVoList", projectVoList);

        return projectListMap;
    } // getProjectList
} // class
