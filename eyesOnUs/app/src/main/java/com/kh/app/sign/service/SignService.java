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

    // 결재 목록 조회 (기안자 입장) (API)
    public List<SignVo> getSignListForWriter(String empNo) {
        return dao.getSignListForWriter(empNo);
    } // getSignListForWriter

    // 결재 목록 조회 (결재자 입장) (API)
    public List<SignVo> getSignListForApprover(String approverNo) {
        return dao.getSignListForApprover(approverNo);
    } // getSignListForApprover

    // 결재 목록 조회 (참조자 입장) (API)
    public List<SignVo> getSignListForReference(String refNo) {
        return dao.getSignListForReference(refNo);
    } // getSignListForReference
} // class
