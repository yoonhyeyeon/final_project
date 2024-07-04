package com.kh.app.sign.controller;

import com.kh.app.sign.service.SignService;
import com.kh.app.sign.vo.EmployeeVo;
import com.kh.app.sign.vo.SignVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sign")
public class SignRestController {
    
    private final SignService service;
    
    // 직원 전체 목록 조회 (API)
    @GetMapping("employeeList")
    public List<EmployeeVo> getEmployeeList(){
        List<EmployeeVo> employeeVoList = service.getEmployeeList();
        return employeeVoList;
    } // getEmployeeList

    // 결재 (API)
    @PutMapping("approve")
    public int updateSignApprove(SignVo signVo){
        int signApproveResult = service.updateSignApprove(signVo);
        return signApproveResult;
    } // updateSignApprove

    // 결재 상세 조회 (API)
    @GetMapping("detail")
    public SignVo getSignDetail(String signNo){
        SignVo signDetailVo = service.getSignDetail(signNo);
        return signDetailVo;
    } // getSignDetail

    // 결재자 상세 조회 (API)
    @GetMapping("approverDetail")
    public SignVo getSignApproverDetail(String signNo){
        SignVo signApproverVo = service.getSignApproverDetail(signNo);
        return signApproverVo;
    } // getSignApproverDetail

    // 결재자 목록 조회 (API)
    @GetMapping("approverList")
    public List<SignVo> getSignApproverList(String empNo){
        List<SignVo> signApproverVoList = service.getSignApproverList(empNo);
        return signApproverVoList;
    } // getSignApproverList

    // 결재 목록 조회 (신청자 입장) (동적 쿼리) (API)
    @GetMapping("employee")
    public List<SignVo> getVoListDynamic(SignVo signVo){
        List<SignVo> signVoListDynamic = service.getVoListDynamic(signVo);
        return signVoListDynamic;
    } // getVoListDynamic

    // 결재 목록 조회 (결재자 입장) (동적 쿼리) (API)
    @GetMapping("approver")
    public List<SignVo> getVoListDynamicForApprover(SignVo signVo){
        List<SignVo> signVoListDynamicForApprover = service.getVoListDynamicForApprover(signVo);
        return signVoListDynamicForApprover;
    } // getVoListDynamicForApprover

    // 결재 목록 조회 (참조자 입장) (동적 쿼리) (API)
    @GetMapping("reference")
    public List<SignVo> getVoListDynamicForReference(SignVo signVo){
        List<SignVo> signVoListDynamicForReference = service.getVoListDynamicForReference(signVo);
        return signVoListDynamicForReference;
    } // getVoListDynamicForReference

//    // 결재 진행 목록 조회 (신청자 입장) (API)
//    @GetMapping("wait")
//    public List<SignVo> getSignWaitList(String empNo){
//        List<SignVo> signWaitVoList = service.getSignWaitList(empNo);
//        return signWaitVoList;
//    } // getSignWaitList
//
//    // 결재 완료 목록 조회 (신청자 입장) (API)
//    @GetMapping("approval")
//    public List<SignVo> getSignApprovalList(String empNo){
//        List<SignVo> signApprovalVoList = service.getSignApprovalList(empNo);
//        return signApprovalVoList;
//    } // getSignApprovalList
//
//    // 결재 반려 목록 조회 (신청자 입장) (API)
//    @GetMapping("return")
//    public List<SignVo> getSignReturnList(String empNo){
//        List<SignVo> signReturnVoList = service.getSignReturnList(empNo);
//        return signReturnVoList;
//    } // getSignReturnList
//
//    // 결재 전체 목록 조회 (신청자 입장) (API)
//    @GetMapping("list")
//    public List<SignVo> getSignList(String empNo){
//        List<SignVo> signVoList = service.getSignList(empNo);
//        return signVoList;
//    } // getSignList
//
//    // 결재 대기 목록 조회 (결재자 입장) (API)
//    @GetMapping("approver/doSign")
//    public List<SignVo> getSignDoSignListForApprover(String approverNo){
//        List<SignVo> signDoSignVoListForApprover = service.getDoSignListForApprover(approverNo);
//        return signDoSignVoListForApprover;
//    } // getSignDoSignListForApprover
//
//    // 결재 진행 목록 조회 (결재자 입장) (API)
//    @GetMapping("approver/wait")
//    public List<SignVo> getSignWaitListForApprover(String approverNo){
//        List<SignVo> signWaitVoListForApprover = service.getSignWaitListForApprover(approverNo);
//        return signWaitVoListForApprover;
//    } // getSignWaitListForApprover
//
//    // 결재 완료 목록 조회 (결재자 입장) (API)
//    @GetMapping("approver/approval")
//    public List<SignVo> getSignApprovalListForApprover(String approverNo){
//        List<SignVo> signApprovalVoListForApprover = service.getSignApprovalListForApprover(approverNo);
//        return signApprovalVoListForApprover;
//    } // getSignApprovalListForApprover
//
//    // 결재 반려 목록 조회 (결재자 입장) (API)
//    @GetMapping("approver/return")
//    public List<SignVo> getSignReturnListForApprover(String approverNo){
//        List<SignVo> signReturnVoListForApprover = service.getSignReturnListForApprover(approverNo);
//        return signReturnVoListForApprover;
//    } // getSignReturnListForApprover
//
//    // 결재 전체 목록 조회 (결재자 입장) (API)
//    @GetMapping("approver/list")
//    public List<SignVo> getSignListForApprover(String approverNo){
//        List<SignVo> signVoListForApprover = service.getSignListForApprover(approverNo);
//        return signVoListForApprover;
//    } // getSignListForApprover
//
//    // 결재 진행 목록 조회 (참조자 입장) (API)
//    @GetMapping("reference/wait")
//    public List<SignVo> getSignWaitListForReference(String refNo){
//        List<SignVo> signWaitVoListForReference = service.getSignWaitListForReference(refNo);
//        return signWaitVoListForReference;
//    } // getSignWaitListForReference
//
//    // 결재 완료 목록 조회 (참조자 입장) (API)
//    @GetMapping("reference/approval")
//    public List<SignVo> getSignApprovalListForReference(String refNo){
//        List<SignVo> signApprovalVoListForReference = service.getSignApprovalListForReference(refNo);
//        return signApprovalVoListForReference;
//    } // getSignApprovalListForReference
//
//    // 결재 반려 목록 조회 (참조자 입장) (API)
//    @GetMapping("reference/return")
//    public List<SignVo> getSignReturnListForReference(String refNo){
//        List<SignVo> signReturnVoListForReference = service.getSignReturnListForReference(refNo);
//        return signReturnVoListForReference;
//    } // getSignReturnListForReference
//
//    // 결재 전체 목록 조회 (참조자 입장) (API)
//    @GetMapping("reference/list")
//    public List<SignVo> getSignListForReference(String refNo){
//        List<SignVo> signVoListForReference = service.getSignListForReference(refNo);
//        return signVoListForReference;
//    } // getSignListForReference
} // class
