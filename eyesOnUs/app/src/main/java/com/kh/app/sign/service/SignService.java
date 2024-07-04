package com.kh.eyes.sign.service;

import com.kh.eyes.sign.dao.SignDao;
import com.kh.eyes.sign.vo.EmployeeVo;
import com.kh.eyes.sign.vo.SignVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class SignService {

    private final SignDao dao;

    // 결재 신청
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

//    // 결재 진행 목록 조회 (신청자 입장) (API)
//    public List<SignVo> getSignWaitList(String empNo) {
//        return dao.getSignWaitList(empNo);
//    } // getSignWaitList
//
//    // 결재 완료 목록 조회 (신청자 입장) (API)
//    public List<SignVo> getSignApprovalList(String empNo) {
//        return dao.getSignApprovalList(empNo);
//    } // getSignApprovalList
//
//    // 결재 반려 목록 조회 (신청자 입장) (API)
//    public List<SignVo> getSignReturnList(String empNo) {
//        return dao.getSignReturnList(empNo);
//    } // getSignReturnList
//
//    // 결재 전체 목록 조회 (신청자 입장) (API)
//    public List<SignVo> getSignList(String empNo) {
//        return dao.getSignList(empNo);
//    } // getSignList
//
//    // 결재 대기 목록 조회 (결재자 입장) (API)
//    public List<SignVo> getDoSignListForApprover(String approverNo) {
//        return dao.getDoSignListForApprover(approverNo);
//    } // getDoSignListForApprover
//
//    // 결재 진행 목록 조회 (결재자 입장) (API)
//    public List<SignVo> getSignWaitListForApprover(String approverNo) {
//        return dao.getSignWaitListForApprover(approverNo);
//    } // getSignWaitListForApprover
//
//    // 결재 완료 목록 조회 (결재자 입장) (API)
//    public List<SignVo> getSignApprovalListForApprover(String approverNo) {
//        return dao.getSignApprovalListForApprover(approverNo);
//    } // getSignApprovalListForApprover
//
//    // 결재 반려 목록 조회 (결재자 입장) (API)
//    public List<SignVo> getSignReturnListForApprover(String approverNo) {
//        return dao.getSignReturnListForApprover(approverNo);
//    } // getSignReturnListForApprover
//
//    // 결재 전체 목록 조회 (결재자 입장) (API)
//    public List<SignVo> getSignListForApprover(String approverNo) {
//        return dao.getSignListForApprover(approverNo);
//    } // getSignListForApprover
//
//    // 결재 진행 목록 조회 (참조자 입장) (API)
//    public List<SignVo> getSignWaitListForReference(String refNo) {
//        return dao.getSignWaitListForReference(refNo);
//    } // getSignWaitListForReference
//
//    // 결재 완료 목록 조회 (참조자 입장) (API)
//    public List<SignVo> getSignApprovalListForReference(String refNo) {
//        return dao.getSignApprovalListForReference(refNo);
//    } // getSignApprovalListForReference
//
//    // 결재 반려 목록 조회 (참조자 입장) (API)
//    public List<SignVo> getSignReturnListForReference(String refNo) {
//        return dao.getSignReturnListForReference(refNo);
//    } // getSignReturnListForReference
//
//    // 결재 전체 목록 조회 (참조자 입장) (API)
//    public List<SignVo> getSignListForReference(String refNo) {
//        return dao.getSignListForReference(refNo);
//    } // getSignListForReference
} // class
