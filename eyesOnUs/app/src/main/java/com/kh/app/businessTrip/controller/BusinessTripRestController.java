package com.kh.app.businessTrip.controller;

import com.kh.app.businessTrip.service.BusinessTripService;
import com.kh.app.businessTrip.vo.BusinessTripVo;
import com.kh.app.businessTrip.vo.ProjectVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/businessTrip")
public class BusinessTripRestController {

    private final BusinessTripService service;

    // 출장 상세 조회 (API)
    @GetMapping("detail")
    public BusinessTripVo getBusinessTripDetail(String businessTripNo){
        BusinessTripVo businessTripDetailVo = service.getBusinessTripDetail(businessTripNo);
        return businessTripDetailVo;
    } // getBusinessTripDetail

    // 출장 승인자 상세 조회 (API)
    @GetMapping("approverDetail")
    public BusinessTripVo getBusinessTripApproverDetail(String businessTripNo){
        BusinessTripVo businessTripAppproverVo = service.getBusinessTripApproverDetail(businessTripNo);
        return businessTripAppproverVo;
    } // getBusinessTripApproverDetail

    // 출장 승인자 목록 조회 (API)
    @GetMapping("approverList")
    public List<BusinessTripVo> getBusinessTripApproverList(String empNo){
        List<BusinessTripVo> businessTripApproverVoList = service.getBusinessTripApproverList(empNo);
        return businessTripApproverVoList;
    } // getBusinessTripApproverList

    // 출장 승인 (API)
    @PutMapping("approve")
    public int updateBusinessTripApprove(BusinessTripVo businessTripVo){
        int businessTripApproveResult = service.updateBusinessTripApprove(businessTripVo);
        return businessTripApproveResult;
    } // updateBusinessTripApprove

    // 프로젝트 목록 조회 (API)
    @GetMapping("projectList")
    public List<ProjectVo> getProjectList(){
        List<ProjectVo> projectVoList = service.getProjectList();
        return projectVoList;
    } // getProjectList

    // 출장 목록 조회 (동적 쿼리) (API)
    @GetMapping
    public List<BusinessTripVo> getBusinessTripListForAll(BusinessTripVo businessTripVo){
        List<BusinessTripVo> businessTripVoListForAll = service.getBusinessTripListForAll(businessTripVo);
        return businessTripVoListForAll;
    } // getBusinessTripForAll

//    // 출장 승인 진행 목록 조회 (신청자 입장) (API)
//    @GetMapping("wait")
//    public List<BusinessTripVo> getBusinessTripWaitList(String empNo){
//        List<BusinessTripVo> businessTripWaitVoList = service.getBusinessTripWaitList(empNo);
//        return businessTripWaitVoList;
//    } // getBusinessTripWaitList
//
//    // 출장 승인 목록 조회 (신청자 입장) (API)
//    @GetMapping("approval")
//    public List<BusinessTripVo> getBusinessTripApprovalList(String empNo){
//        List<BusinessTripVo> businessTripApprovalVoList = service.getBusinessTripApprovalList(empNo);
//        return businessTripApprovalVoList;
//    } // getBusinessTripApprovalList
//
//    // 출장 반려 목록 조회 (신청자 입장) (API)
//    @GetMapping("return")
//    public List<BusinessTripVo> getBusinessTripReturnList(String empNo){
//        List<BusinessTripVo> businessTripReturnVoList = service.getBusinessTripReturnList(empNo);
//        return businessTripReturnVoList;
//    } // getBusinessTripReturnList
//
//    // 출장 전체 목록 조회 (신청자 입장) (API)
//    @GetMapping("list")
//    public List<BusinessTripVo> getBusinessTripList(String empNo){
//        List<BusinessTripVo> businessTripVoList = service.getBusinessTripList(empNo);
//        return businessTripVoList;
//    } // getBusinessTripList
//
//    // 출장 승인 진행 목록 조회 (승인자 입장) (API)
//    @GetMapping("approver/wait")
//    public List<BusinessTripVo> getBusinessTripWaitListForApprover(String approverNo){
//        List<BusinessTripVo> businessTripWaitVoListForApprover = service.getBusinessTripWaitListForApprover(approverNo);
//        return businessTripWaitVoListForApprover;
//    } // getBusinessTripWaitListForApprover
//
//    // 출장 승인 목록 조회 (승인자 입장) (API)
//    @GetMapping("approver/approval")
//    public List<BusinessTripVo> getBusinessTripApprovalListForApprover(String approverNo){
//        List<BusinessTripVo> businessTripApprovalVoListForApprover = service.getBusinessTripApprovalListForApprover(approverNo);
//        return businessTripApprovalVoListForApprover;
//    } // getBusinessTripApprovalListForApprover
//
//    // 출장 반려 목록 조회 (승인자 입장) (API)
//    @GetMapping("approver/return")
//    public List<BusinessTripVo> getBusinessTripReturnListForApprover(String approverNo){
//        List<BusinessTripVo> businessTripReturnVoListForApprover = service.getBusinessTripReturnListForApprover(approverNo);
//        return businessTripReturnVoListForApprover;
//    } // getBusinessTripReturnListForApprover
//
//    // 출장 전체 목록 조회 (승인자 입장) (API)
//    @GetMapping("approver/list")
//    public List<BusinessTripVo> getBusinessTripListForApprover(String approverNo){
//        List<BusinessTripVo> businessTripVoListForApprover = service.getBusinessTripListForApprover(approverNo);
//        return businessTripVoListForApprover;
//    } // getBusinessTripListForApprover
} // class
