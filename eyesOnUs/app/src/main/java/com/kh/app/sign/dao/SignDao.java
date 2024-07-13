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
    public int signWrite(SignVo vo) {
        int signResult = mapper.signWrite(vo);
        if(signResult != 1){
            throw new RuntimeException("[S-000] SIGN INSERT ERROR");
        }
        return signResult;
    } // signWrite

    // 기안 (SIGN_FILE)
    public int signFileWrite(SignVo vo) {
        int fileResult = mapper.signFileWrite(vo);
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

    // 결재 (API)
    public int updateSignApprove(SignVo signVo) {
        int signApproveResult = mapper.updateSignApprove(signVo);
        if(signApproveResult != 1){
            throw new RuntimeException("[S-005] SIGN APPROVE UPDATE ERROR");
        }
        return signApproveResult;
    } // updateSignApprove

    // 결재 목록 조회 (기안자 입장) (API)
    public List<SignVo> getSignListForWriter(String empNo) {
        List<SignVo> signVoListForWriter = mapper.getSignListForWriter(empNo);
        if(signVoListForWriter == null){
            throw new RuntimeException("[S-006] SIGN LIST FOR WRITER SELECT ERROR");
        }
        return signVoListForWriter;
    } // getSignListForWriter

    // 결재 목록 조회 (결재자 입장) (API)
    public List<SignVo> getSignListForApprover(String approverNo) {
        List<SignVo> signVoListForApprover = mapper.getSignListForApprover(approverNo);
        if(signVoListForApprover == null){
            throw new RuntimeException("[S-007] SIGN LIST FOR APPROVER SELECT ERROR");
        }
        return signVoListForApprover;
    } // getSignListForApprover

    // 결재 목록 조회 (참조자 입장) (API)
    public List<SignVo> getSignListForReference(String refNo) {
        List<SignVo> signVoListForReference = mapper.getSignListForReference(refNo);
        if(signVoListForReference == null){
            throw new RuntimeException("[S-008] SIGN LIST FOR REFERENCE SELECT ERROR");
        }
        return signVoListForReference;
    } // getSignListForReference
} // class
