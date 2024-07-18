package com.kh.app.sign.controller;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.sign.service.SignService;
import com.kh.app.sign.vo.SignVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sign")
public class SignRestController {
    
    private final SignService service;
    
    // 직원 전체 목록 조회 (API)
    @GetMapping("employeeList")
    public Map<String, List> getEmployeeList(){
        Map<String, List> employeeListMap = service.getEmployeeList();

        return employeeListMap;
    } // getEmployeeList

    // 결재 목록 조회 (기안자 입장) (API)
    @GetMapping("listForWriter")
    public Map<String, List> getSignListForWriter(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String empNo = loginMemberVo.getNo();
        
        Map<String, List> signListMapForWriter = service.getSignListForWriter(empNo);

        return signListMapForWriter;
    } // getSignListForWriter
    
    // 결재 목록 조회 (결재자 입장) (API)
    @GetMapping("listForApprover")
    public Map<String, List> getSignListForApprover(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String approverNo = loginMemberVo.getNo();

        Map<String, List> signListMapForApprover = service.getSignListForApprover(approverNo);

        return signListMapForApprover;
    } // getSignListForApprover

    // 결재 목록 조회 (참조자 입장) (API)
    @GetMapping("listForReference")
    public Map<String, List> getSignListForReference(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String refNo = loginMemberVo.getNo();

        Map<String, List> signListMapForReference = service.getSignListForReference(refNo);

        return signListMapForReference;
    } // getSignListForReference

    // 결재 상세 조회 (API)
    @GetMapping("detail")
    public Map<String, SignVo> getSignDetail(SignVo signVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        Map<String, SignVo> signDetailMap = service.getSignDetail(signVo, loginMemberVo);

        return signDetailMap;
    } // getSignDetail

    // 결재자, 참조자 상세 조회 (API)
    @GetMapping("detailList")
    public Map<String, List> getSignApproverAndReferenceDetailList(SignVo signVo){
        Map<String, List> signApproverAndReferenceDetailMap = service.getSignApproverDetailList(signVo);

        return signApproverAndReferenceDetailMap;
    } // getSignApproverAndReferenceDetailList

    // 결재 (API)
    @PutMapping("approve")
    public Map<String, Integer> updateSignApprove(SignVo signVo){
        MultipartFile file = signVo.getFile();
        if(file != null && !file.isEmpty()){
            signVo.setSize(String.valueOf(file.getSize()));
            signVo.setChangeName(file.getOriginalFilename());
        }

        Map<String, Integer> signApproveResultMap = service.updateSignApprove(signVo);

        return signApproveResultMap;
    } // updateSignApprove
} // class
