package com.kh.app.sign.controller;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.sign.service.SignService;
import com.kh.app.sign.vo.EmployeeVo;
import com.kh.app.sign.vo.SignVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        List<EmployeeVo> employeeVoList = service.getEmployeeList();

        Map<String, List> employeeListMap = new HashMap<>();
        employeeListMap.put("employeeVoList", employeeVoList);

        return employeeListMap;
    } // getEmployeeList

    // 결재 목록 조회 (기안자 입장) (API)
    @GetMapping("listForWriter")
    public Map<String, List> getSignListForWriter(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String empNo = loginMemberVo.getNo();

        List<SignVo> signVoListForWriter = service.getSignListForWriter(empNo);
        
        Map<String, List> signListMapForWriter = new HashMap<>();
        signListMapForWriter.put("signVoListForWriter", signVoListForWriter);

        return signListMapForWriter;
    } // getSignListForWriter
    
    // 결재 목록 조회 (결재자 입장) (API)
    @GetMapping("listForApprover")
    public Map<String, List> getSignListForApprover(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String approverNo = loginMemberVo.getNo();

        List<SignVo> signVoListForApprover = service.getSignListForApprover(approverNo);

        Map<String, List> signListMapForApprover = new HashMap<>();
        signListMapForApprover.put("signVoListForApprover", signVoListForApprover);

        return signListMapForApprover;
    } // getSignListForApprover

    // 결재 목록 조회 (참조자 입장) (API)
    @GetMapping("listForReference")
    public Map<String, List> getSignListForReference(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String refNo = loginMemberVo.getNo();

        List<SignVo> signVoListForReference = service.getSignListForReference(refNo);

        Map<String, List> signListMapForReference = new HashMap<>();
        signListMapForReference.put("signVoListForReference", signVoListForReference);

        return signListMapForReference;
    } // getSignListForReference

    // 결재 상세 조회 (API)
    public Map<String, SignVo> getSignDetail(SignVo signVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        // 결재 상세 조회 (API)
        SignVo signDetailVo = service.getSignDetail(signVo);
        Map<String, SignVo> signDetailMap = new HashMap<>();
        signDetailMap.put("signDetailVo", signDetailVo);

        // 결재자 상세 조회 (API)
        SignVo signApproverDetailVo = service.getSignApproverDetail(signVo);
        signDetailMap.put("signApproverDetailVo", signApproverDetailVo);

        // 참조자 상세 조회 (API)
        SignVo signReferenceDetailVo = service.getSignReferenceDetail(signVo);
        signDetailMap.put("signReferenceDetailVo", signReferenceDetailVo);

        // 승인, 반려 버튼 판단용 로그인 사원 번호
        SignVo vo = new SignVo();
        vo.setEmpNo(loginMemberVo.getNo());
        signDetailMap.put("vo", vo);

        return signDetailMap;
    } // getSignDetail

//    // 결재 (API)
//    @PutMapping("approve")
//    public Map<String, Integer> updateSignApprove(SignVo signVo){
//        int signApproveResult = service.updateSignApprove(signVo);
//
//        Map<String, Integer> signApproveResultMap = new HashMap<>();
//        signApproveResultMap.put("signApproveResult", signApproveResult);
//
//        return signApproveResultMap;
//    } // updateSignApprove
} // class
