package com.kh.app.sign.service;

import com.kh.app.sign.dao.SignDao;
import com.kh.app.sign.vo.EmployeeVo;
import com.kh.app.sign.vo.SignVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SignService {

    private final SignDao dao;

    // 기안
    public int signWrite(SignVo vo) {
        int signResult = dao.signWrite(vo);
        int fileResult = dao.signFileWrite(vo);

        int signSeq = 1;
        int pathResult = 0;
        for (String approver : vo.getApproverNo()) {
            pathResult = dao.signPathWrite(approver, signSeq);
            signSeq++;
        }

        int refResult = 0;
        for (String ref : vo.getRefNo()) {
            refResult = dao.signRefWrite(ref);
        }
        return signResult * fileResult * pathResult * refResult;
    } // signWrite

    // 직원 전체 목록 조회 (API)
    public List<EmployeeVo> getEmployeeList() {
        return dao.getEmployeeList();
    } // getEmployeeList

    // 결재 (API)
    public int updateSignApprove(SignVo signVo) {
        return dao.updateSignApprove(signVo);
    } // updateSignApprove




    // 결재 상세 조회 (API)
    public SignVo getSignDetail(String signNo) {
        return dao.getSignDetail(signNo);
    } // getSignDetail

    // 결재자 상세 조회 (API)
    public SignVo getSignApproverDetail(String signNo) {
        return dao.getSignApproverDetail(signNo);
    } // getSignApproverDetail

    // 결재자 목록 조회 (API)
    public List<SignVo> getSignApproverList(String empNo) {
        return dao.getSignApproverList(empNo);
    } // getSignApproverList

    // 결재 목록 조회 (신청자 입장) (동적 쿼리) (API)
    public List<SignVo> getVoListDynamic(SignVo signVo) {
        return dao.getVoListDynamic(signVo);
    } // getVoListDynamic

    // 결재 목록 조회 (결재자 입장) (동적 쿼리) (API)
    public List<SignVo> getVoListDynamicForApprover(SignVo signVo) {
        return dao.getVoListDynamicForApprover(signVo);
    } // getVoListDynamicForApprover

    // 결재 목록 조회 (참조자 입장) (동적 쿼리) (API)
    public List<SignVo> getVoListDynamicForReference(SignVo signVo) {
        return dao.getVoListDynamicForReference(signVo);
    } // getVoListDynamicForReference
} // class
