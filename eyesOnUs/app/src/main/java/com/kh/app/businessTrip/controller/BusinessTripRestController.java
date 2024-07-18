package com.kh.app.businessTrip.controller;

import com.kh.app.businessTrip.service.BusinessTripService;
import com.kh.app.businessTrip.vo.BusinessTripVo;
import com.kh.app.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/businessTrip")
public class BusinessTripRestController {

    private final BusinessTripService service;

    // 출장 목록 조회 (신청자 입장) (API)
    @GetMapping("listForWriter")
    public Map<String, List> getBusinessTripListForWriter(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String empNo = loginMemberVo.getNo();

        Map<String, List> businessTripListMapForWriter = service.getBusinessTripListForWriter(empNo);

        return businessTripListMapForWriter;
    } // getBusinessTripListForWriter

    // 출장 목록 조회 (승인자 입장) (API)
    @GetMapping("listForApprover")
    public Map<String, List> getBusinessTripListForApprover(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String approverNo = loginMemberVo.getNo();

        Map<String, List> businessTripListMapForApprover = service.getBusinessTripListForApprover(approverNo);

        return businessTripListMapForApprover;
    } // getBusinessTripListForApprover

    // 출장 상세 조회 (API)
    @GetMapping("detail")
    public Map<String, BusinessTripVo> getBusinessTripDetail(BusinessTripVo businessTripVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        Map<String, BusinessTripVo> businessTripDetailMap = service.getBusinessTripDetail(businessTripVo, loginMemberVo);

        return businessTripDetailMap;
    } // getBusinessTripDetail

    // 출장 승인 (API)
    @PutMapping("approve")
    public Map<String, Integer> updateBusinessTripApprove(BusinessTripVo businessTripVo){
        Map<String, Integer> businessTripApproveResultMap = service.updateBusinessTripApprove(businessTripVo);

        return businessTripApproveResultMap;
    } // updateBusinessTripApprove

    // 프로젝트 목록 조회 (API)
    @GetMapping("projectList")
    public Map<String, List> getProjectList(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String empNo = loginMemberVo.getNo();

        Map<String, List> projectListMap = service.getProjectList(empNo);

        return projectListMap;
    } // getProjectList
} // class
