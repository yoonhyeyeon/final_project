package com.kh.app.sign.dao;

import com.kh.app.sign.mapper.SignMapper;
import com.kh.app.sign.vo.EmployeeVo;
import com.kh.app.sign.vo.SignVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SignDao {

    private final SignMapper mapper;

    // 기안 (SIGN)
    public int signWrite(SignVo signVo) {
        int signResult = mapper.signWrite(signVo);
        if(signResult != 1){
            throw new RuntimeException("[S-000] SIGN INSERT ERROR");
        }
        return signResult;
    } // signWrite

    // 기안 (SIGN_FILE)
    public int signFileWrite(SignVo signVo) {
        int fileResult = mapper.signFileWrite(signVo);
        if(fileResult != 1){
            throw new RuntimeException("[S-001] SIGN_FILE INSERT ERROR");
        }
        return fileResult;
    } // signFileWrite

    // 기안 (SIGN_PATH)
    public int signPathWrite(String approver, int signSeq) {
        int pathResult = mapper.signPathWrite(approver, signSeq);
        if(pathResult != 1){
            throw new RuntimeException("[S-002] SIGN_PATH INSERT ERROR");
        }
        return pathResult;
    } // signPathWrite

    // 기안 (SIGN_REF)
    public int signRefWrite(String ref) {
        int refResult = mapper.signRefWrite(ref);
        if(refResult != 1){
            throw new RuntimeException("[S-003] SIGN_REF INSERT ERROR");
        }
        return refResult;
    } // signRefWrite

    // 직원 전체 목록 조회 (API)
    public List<EmployeeVo> getEmployeeList() {
        List<EmployeeVo> employeeVoList = mapper.getEmployeeList();
        if(employeeVoList == null){
            throw new RuntimeException("[S-004] EMPLOYEE LIST SELECT ERROR");
        }
        return employeeVoList;
    } // getEmployeeList

    // 결재 목록 조회 (기안자 입장) (API)
    public List<SignVo> getSignListForWriter(String empNo) {
        List<SignVo> signVoListForWriter = mapper.getSignListForWriter(empNo);
        if(signVoListForWriter == null){
            throw new RuntimeException("[S-005] SIGN LIST FOR WRITER SELECT ERROR");
        }
        return signVoListForWriter;
    } // getSignListForWriter

    // 결재 목록 조회 (결재자 입장) (API)
    public List<SignVo> getSignListForApprover(String approverNo) {
        List<SignVo> signVoListForApprover = mapper.getSignListForApprover(approverNo);
        if(signVoListForApprover == null){
            throw new RuntimeException("[S-006] SIGN LIST FOR APPROVER SELECT ERROR");
        }
        return signVoListForApprover;
    } // getSignListForApprover

    // 결재 목록 조회 (참조자 입장) (API)
    public List<SignVo> getSignListForReference(String refNo) {
        List<SignVo> signVoListForReference = mapper.getSignListForReference(refNo);
        if(signVoListForReference == null){
            throw new RuntimeException("[S-007] SIGN LIST FOR REFERENCE SELECT ERROR");
        }
        return signVoListForReference;
    } // getSignListForReference

    // 결재 상세 조회 (API)
    public SignVo getSignDetail(SignVo signVo) {
        SignVo signDetailVo = mapper.getSignDetail(signVo);
        if(signDetailVo == null){
            throw new RuntimeException("[S-008] SIGN DETAIL SELECT ERROR");
        }
        return signDetailVo;
    } // getSignDetail

    // 결재자 상세 조회 (API)
    public List<SignVo> getSignApproverDetailList(SignVo signVo) {
        List<SignVo> signApproverDetailVoList = mapper.getSignApproverDetailList(signVo);
        if(signApproverDetailVoList == null){
            throw new RuntimeException("[S-009] SIGN APPROVER DETAIL LIST SELECT ERROR");
        }
        return signApproverDetailVoList;
    } // getSignApproverDetailList

    // 참조자 상세 조회 (API)
    public List<SignVo> getSignReferenceDetailList(SignVo signVo) {
        List<SignVo> signReferenceDetailVoList = mapper.getSignReferenceDetailList(signVo);
        return signReferenceDetailVoList;
    } // getSignReferenceDetailList

    // 결재 (SIGN) (API)
    public int updateSign(SignVo signVo) {
        int signResult = mapper.updateSign(signVo);
        if(signResult != 1){
            throw new RuntimeException("[S-010] SIGN APPROVE UPDATE ERROR");
        }
        return signResult;
    } // updateSign

    // 결재 (SIGN_FILE) (API)
    public int updateFile(SignVo signVo) {
        int fileResult = mapper.updateFile(signVo);
        if(fileResult != 1){
            throw new RuntimeException("[S-011] SIGN_FILE APPROVE UPDATE ERROR");
        }
        return fileResult;
    } // updateFile

    // 결재 (SIGN_COM) (API)
    public int writeComment(SignVo signVo) {
        int commentResult = mapper.writeComment(signVo);
        if(commentResult != 1){
            throw new RuntimeException("[S-012] SIGN_COM APPROVE INSERT ERROR");
        }
        return commentResult;
    } // writeComment
} // class
