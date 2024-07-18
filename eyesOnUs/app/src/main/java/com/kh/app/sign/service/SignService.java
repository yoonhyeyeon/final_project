package com.kh.app.sign.service;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.sign.dao.SignDao;
import com.kh.app.sign.vo.EmployeeVo;
import com.kh.app.sign.vo.SignVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class SignService {

    private final SignDao dao;

    // 기안
    public int signWrite(SignVo signVo) {
        int signResult = dao.signWrite(signVo);
        int fileResult = dao.signFileWrite(signVo);

        int signSeq = 1;
        int pathResult = 0;
        for (String approver : signVo.getApproverNo()) {
            pathResult = dao.signPathWrite(approver, signSeq);
            signSeq++;
        }

        int refResult = 0;
        if(signVo.getRefNo() != null){
            for (String ref : signVo.getRefNo()) {
                refResult = dao.signRefWrite(ref);
            }
        }

        return signResult * fileResult * pathResult * refResult;
    } // signWrite

    // 직원 전체 목록 조회 (API)
    public Map<String, List> getEmployeeList() {
        // 직원 전체 목록 조회 (API)
        List<EmployeeVo> employeeVoList = dao.getEmployeeList();

        // 직원 전체 목록 묶기
        Map<String, List> employeeListMap = new HashMap<>();
        employeeListMap.put("employeeVoList", employeeVoList);

        return employeeListMap;
    } // getEmployeeList

    // 결재 목록 조회 (기안자 입장) (API)
    public Map<String, List> getSignListForWriter(String empNo) {
        // 결재 목록 조회 (기안자 입장) (API)
        List<SignVo> signVoListForWriter = dao.getSignListForWriter(empNo);

        // 결재 목록 묶기
        Map<String, List> signListMapForWriter = new HashMap<>();
        signListMapForWriter.put("signVoListForWriter", signVoListForWriter);

        return signListMapForWriter;
    } // getSignListForWriter

    // 결재 목록 조회 (결재자 입장) (API)
    public Map<String, List> getSignListForApprover(String approverNo) {
        // 결재 목록 조회 (결재자 입장) (API)
        List<SignVo> signVoListForApprover = dao.getSignListForApprover(approverNo);

        // 결재 목록 묶기
        Map<String, List> signListMapForApprover = new HashMap<>();
        signListMapForApprover.put("signVoListForApprover", signVoListForApprover);

        return signListMapForApprover;
    } // getSignListForApprover

    // 결재 목록 조회 (참조자 입장) (API)
    public Map<String, List> getSignListForReference(String refNo) {
        // 결재 목록 조회 (참조자 입장) (API)
        List<SignVo> signVoListForReference = dao.getSignListForReference(refNo);

        // 결재 목록 묶기
        Map<String, List> signListMapForReference = new HashMap<>();
        signListMapForReference.put("signVoListForReference", signVoListForReference);
        
        return signListMapForReference;
    } // getSignListForReference

    // 결재 상세 조회 (API)
    public Map<String, SignVo> getSignDetail(SignVo signVo, MemberVo loginMemberVo) {
        // 결재 상세 조회 (API)
        SignVo signDetailVo = dao.getSignDetail(signVo);

        // 승인, 반려 버튼 판단용 로그인 사원 번호
        SignVo vo = new SignVo();
        vo.setEmpNo(loginMemberVo.getNo());

        // 결재 상세, 로그인 사원 번호 묶기
        Map<String, SignVo> signDetailMap = new HashMap<>();
        signDetailMap.put("signDetailVo", signDetailVo);
        signDetailMap.put("vo", vo);

        return signDetailMap;
    } // getSignDetail

    // 결재자 상세 조회 (API)
    public Map<String, List> getSignApproverDetailList(SignVo signVo) {
        // 결재자 상세 조회 (API)
        List<SignVo> signApproverDetailVoList = dao.getSignApproverDetailList(signVo);

        // 참조자 상세 조회 (API)
        List<SignVo> signReferenceDetailVoList = dao.getSignReferenceDetailList(signVo);

        // 결재자 상세, 참조자 상세 묶기
        Map<String, List> signApproverAndReferenceDetailMap = new HashMap<>();
        signApproverAndReferenceDetailMap.put("signApproverDetailVoList", signApproverDetailVoList);
        signApproverAndReferenceDetailMap.put("signReferenceDetailVoList", signReferenceDetailVoList);

        return signApproverAndReferenceDetailMap;
    } // getSignApproverDetailList

    // 결재 (API)
    public Map<String, Integer> updateSignApprove(SignVo signVo) {
        // 결재 (API)
        int signResult = dao.updateSign(signVo);
        int fileResult = dao.updateFile(signVo);
        int commentResult = dao.writeComment(signVo);

        // 결재 정보 묶기
        int signApproveResult = signResult * fileResult * commentResult;
        Map<String, Integer> signApproveResultMap = new HashMap<>();
        signApproveResultMap.put("signApproveResult", signApproveResult);

        return signApproveResultMap;
    } // updateSignApprove
} // class
