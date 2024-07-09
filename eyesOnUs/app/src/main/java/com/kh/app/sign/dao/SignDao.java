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
            throw new RuntimeException("[S-018] SIGN STATE UPDATE ERROR");
        }
        return signApproveResult;
    } // updateSignApprove
    
    
    
    
    
    

    // 결재 상세 조회 (API)
    public SignVo getSignDetail(String signNo) {
        SignVo signDetailVo = mapper.getSignDetail(signNo);
        if(signDetailVo == null){
            throw new RuntimeException("[S-019] SIGN DETAIL SELECT ERROR");
        }
        return signDetailVo;
    } // getSignDetail

    // 결재자 상세 조회 (API)
    public SignVo getSignApproverDetail(String signNo) {
        SignVo signApproverDetailVo = mapper.getSignApproverDetail(signNo);
        if(signApproverDetailVo == null){
            throw new RuntimeException("[S-020] SIGN APPROVER DETAIL SELECT ERROR");
        }
        return signApproverDetailVo;
    } // getSignApproverDetail

    // 결재자 목록 조회 (API)
    public List<SignVo> getSignApproverList(String empNo) {
        List<SignVo> signApproverVoList = mapper.getSignApproverList(empNo);
        if(signApproverVoList == null){
            throw new RuntimeException("[S-021] SIGN APPROVER LIST SELECT ERROR");
        }
        return signApproverVoList;
    } // getSignApproverList

    // 결재 목록 조회 (신청자 입장) (동적 쿼리) (API)
    public List<SignVo> getVoListDynamic(SignVo signVo) {
        List<SignVo> signVoListDynamic = mapper.getVoListDynamic(signVo);
        if(signVoListDynamic == null){
            throw new RuntimeException("[S-022] SIGN LIST DYNAMIC SELECT ERROR");
        }
        return signVoListDynamic;
    } // getVoListDynamic

    // 결재 목록 조회 (결재자 입장) (동적 쿼리) (API)
    public List<SignVo> getVoListDynamicForApprover(SignVo signVo) {
        List<SignVo> signVoListDynamicForApprover = mapper.getVoListDynamicForApprover(signVo);
        if(signVoListDynamicForApprover == null){
            throw new RuntimeException("[S-023] SIGN LIST DYNAMIC FOR APPROVER SELECT ERROR");
        }
        return signVoListDynamicForApprover;
    } // getVoListDynamicForApprover

    // 결재 목록 조회 (참조자 입장) (동적 쿼리) (API)
    public List<SignVo> getVoListDynamicForReference(SignVo signVo) {
        List<SignVo> signVoListDynamicForReference = mapper.getVoListDynamicForReference(signVo);
        if(signVoListDynamicForReference == null){
            throw new RuntimeException("[S-024] SIGN LIST DYNAMIC FOR REFERENCE SELECT ERROR");
        }
        return signVoListDynamicForReference;
    } // getVoListDynamicForReference
} // class
