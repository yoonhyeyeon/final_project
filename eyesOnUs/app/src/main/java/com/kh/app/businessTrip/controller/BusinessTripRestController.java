package com.kh.app.businessTrip.controller;

import com.kh.app.businessTrip.service.BusinessTripService;
import com.kh.app.businessTrip.vo.BusinessTripVo;
import com.kh.app.businessTrip.vo.ProjectVo;
import com.kh.app.leave.vo.LeaveVo;
import com.kh.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/businessTrip")
public class BusinessTripRestController {

    private final BusinessTripService service;

    // 출장 목록 조회 (신청자 입장) (API)
    @GetMapping("listForWriter")
    public Map<String, List> getBusinessTripListForWriter(BusinessTripVo businessTripVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String empNo = loginMemberVo.getNo();

        // 출장 목록 조회 (신청자 입장) (API)
        List<BusinessTripVo> businessTripVoListForWriter = service.getBusinessTripListForWriter(empNo);
        Map<String, List> businessTripListMapForWriter = new HashMap<>();
        businessTripListMapForWriter.put("businessTripVoListForWriter", businessTripVoListForWriter);

        // 출장 승인자 목록 조회 (신청자 입장) (API)
        List<BusinessTripVo> businessTripApproverVoListForWriter = service.getBusinessTripApproverListForWriter(empNo);
        businessTripListMapForWriter.put("businessTripApproverVoListForWriter", businessTripApproverVoListForWriter);

        return businessTripListMapForWriter;
    } // getBusinessTripListForWriter

    // 출장 목록 조회 (승인자 입장) (API)
    @GetMapping("listForApprover")
    public Map<String, List> getBusinessTripListForApprover(BusinessTripVo businessTripVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String approverNo = loginMemberVo.getNo();

        // 출장 목록 조회 (승인자 입장) (API)
        List<BusinessTripVo> businessTripVoListForApprover = service.getBusinessTripListForApprover(approverNo);
        Map<String, List> businessTripListMapForApprover = new HashMap<>();
        businessTripListMapForApprover.put("businessTripVoListForApprover", businessTripVoListForApprover);

        // 출장 승인자 목록 조회 (승인자 입장) (API)
        List<BusinessTripVo> businessTripApproverVoListForApprover = service.getBusinessTripApproverListForApprover(approverNo);
        businessTripListMapForApprover.put("businessTripApproverVoListForApprover", businessTripApproverVoListForApprover);

        return businessTripListMapForApprover;
    } // getBusinessTripListForApprover

    // 출장 상세 조회 (API)
    @GetMapping("detail")
    public Map<String, BusinessTripVo> getBusinessTripDetail(BusinessTripVo businessTripVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        // 출장 상세 조회 (API)
        BusinessTripVo businessTripDetailVo = service.getBusinessTripDetail(businessTripVo);
        Map<String, BusinessTripVo> businessTripDetailMap = new HashMap<>();
        businessTripDetailMap.put("businessTripDetailVo", businessTripDetailVo);

        // 출장 승인자 상세 조회 (API)
        BusinessTripVo businessTripApproverDetailVo = service.getBusinessTripApproverDetail(businessTripVo);
        businessTripDetailMap.put("businessTripApproverDetailVo", businessTripApproverDetailVo);

        // 승인, 반려 버튼 판단용 로그인 사원 번호
        BusinessTripVo vo = new BusinessTripVo();
        vo.setEmpNo(loginMemberVo.getNo());
        businessTripDetailMap.put("vo", vo);

        return businessTripDetailMap;
    } // getBusinessTripDetail

    // 출장 승인 (API)
    @PutMapping("approve")
    public Map<String, Integer> updateBusinessTripApprove(BusinessTripVo businessTripVo){
        int businessTripApproveResult = service.updateBusinessTripApprove(businessTripVo);

        Map<String, Integer> businessTripApproveResultMap = new HashMap<>();
        businessTripApproveResultMap.put("businessTripApproveResult", businessTripApproveResult);

        return businessTripApproveResultMap;
    } // updateBusinessTripApprove

    // 프로젝트 목록 조회 (API)
    @GetMapping("projectList")
    public Map<String, List> getProjectList(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String empNo = loginMemberVo.getNo();
        List<ProjectVo> projectVoList = service.getProjectList(empNo);

        Map<String, List> projectListMap = new HashMap<>();
        projectListMap.put("projectVoList", projectVoList);

        return projectListMap;
    } // getProjectList
} // class
