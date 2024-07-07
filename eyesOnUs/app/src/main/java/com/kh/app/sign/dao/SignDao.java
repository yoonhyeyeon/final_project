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

    // 결재 신청 (SIGN)
    public int signWrite(SignVo vo) {
        int signResult = mapper.signWrite(vo);
        if(signResult != 1){
            throw new RuntimeException("[S-000] SIGN INSERT ERROR");
        }
        return signResult;
    } // signWrite

    // 결재 신청 (SIGN_FILE)
    public int signFileWrite(SignVo vo) {
        int fileResult = mapper.signFileWrite(vo);
        if(fileResult != 1){
            throw new RuntimeException("[S-001] SIGN_FILE INSERT ERROR");
        }
        return fileResult;
    } // signFileWrite

    // 결재 신청 (SIGN_PATH)
    public int signPathWrite(String approver, int signSeq) {
        int pathResult = mapper.signPathWrite(approver, signSeq);
        if(pathResult != 1){
            throw new RuntimeException("[S-002] SIGN_PATH INSERT ERROR");
        }
        return pathResult;
    } // signPathWrite

    // 결재 신청 (SIGN_REF)
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

//    // 결재 진행 목록 조회 (신청자 입장) (API)
//    public List<SignVo> getSignWaitList(String empNo) {
//        List<SignVo> signWaitVoList = mapper.getSignWaitList(empNo);
//        if(signWaitVoList == null){
//            throw new RuntimeException("[S-005] SIGN WAIT LIST SELECT ERROR");
//        }
//        return signWaitVoList;
//    } // getSignWaitList
//
//    // 결재 완료 목록 조회 (신청자 입장) (API)
//    public List<SignVo> getSignApprovalList(String empNo) {
//        List<SignVo> signApprovalVoList = mapper.getSignApprovalList(empNo);
//        if(signApprovalVoList == null){
//            throw new RuntimeException("[S-006] SIGN APPROVAL LIST SELECT ERROR");
//        }
//        return signApprovalVoList;
//    } // getSignApprovalList
//
//    // 결재 반려 목록 조회 (신청자 입장) (API)
//    public List<SignVo> getSignReturnList(String empNo) {
//        List<SignVo> signReturnVoList = mapper.getSignReturnList(empNo);
//        if(signReturnVoList == null){
//            throw new RuntimeException("[S-007] SIGN RETURN LIST SELECT ERROR");
//        }
//        return signReturnVoList;
//    } // getSignReturnList
//
//    // 결재 전체 목록 조회 (신청자 입장) (API)
//    public List<SignVo> getSignList(String empNo) {
//        List<SignVo> signVoList = mapper.getSignList(empNo);
//        if(signVoList == null){
//            throw new RuntimeException("[S-008] SIGN LIST SELECT ERROR");
//        }
//        return signVoList;
//    } // getSignList
//
//    // 결재 대기 목록 조회 (결재자 입장) (API)
//    public List<SignVo> getDoSignListForApprover(String approverNo) {
//        List<SignVo> signDoSignVoListForApprover = mapper.getDoSignListForApprover(approverNo);
//        if(signDoSignVoListForApprover == null){
//            throw new RuntimeException("[S-009] SIGN DO_SIGN LIST FOR APPROVER SELECT ERROR");
//        }
//        return signDoSignVoListForApprover;
//    } // getDoSignListForApprover
//
//    // 결재 진행 목록 조회 (결재자 입장) (API)
//    public List<SignVo> getSignWaitListForApprover(String approverNo) {
//        List<SignVo> signDoSignVoListForApprover = mapper.getSignWaitListForApprover(approverNo);
//        if(signDoSignVoListForApprover == null){
//            throw new RuntimeException("[S-010] SIGN WAIT LIST FOR APPORVER SELECT ERROR");
//        }
//        return signDoSignVoListForApprover;
//    } // getSignWaitListForApprover
//
//    // 결재 완료 목록 조회 (결재자 입장) (API)
//    public List<SignVo> getSignApprovalListForApprover(String approverNo) {
//        List<SignVo> signApprovalVoListForApprover = mapper.getSignApprovalListForApprover(approverNo);
//        if(signApprovalVoListForApprover == null){
//            throw new RuntimeException("[S-011] SIGN APPROVAL LIST FOR APPROVER SELECT ERROR");
//        }
//        return signApprovalVoListForApprover;
//    } // getSignApprovalListForApprover
//
//    // 결재 반려 목록 조회 (결재자 입장) (API)
//    public List<SignVo> getSignReturnListForApprover(String approverNo) {
//        List<SignVo> signReturnVoListForApprover = mapper.getSignReturnListForApprover(approverNo);
//        if(signReturnVoListForApprover == null){
//            throw new RuntimeException("[S-012] SIGN RETURN LIST FOR APPROVER SELECT ERROR");
//        }
//        return signReturnVoListForApprover;
//    } // getSignReturnListForApprover
//
//    // 결재 전체 목록 조회 (결재자 입장) (API)
//    public List<SignVo> getSignListForApprover(String approverNo) {
//        List<SignVo> signVoListForApprover = mapper.getSignListForApprover(approverNo);
//        if(signVoListForApprover == null){
//            throw new RuntimeException("[S-013] SIGN LIST FOR APPROVER SELECT ERROR");
//        }
//        return signVoListForApprover;
//    } // getSignListForApprover
//
//    // 결재 진행 목록 조회 (참조자 입장) (API)
//    public List<SignVo> getSignWaitListForReference(String refNo) {
//        List<SignVo> signWaitVoListForReference = mapper.getSignWaitListForReference(refNo);
//        if(signWaitVoListForReference == null){
//            throw new RuntimeException("[S-014] SIGN WAIT LIST FOR REFERENCE SELECT ERROR");
//        }
//        return signWaitVoListForReference;
//    } // getSignWaitListForReference
//
//    // 결재 완료 목록 조회 (참조자 입장) (API)
//    public List<SignVo> getSignApprovalListForReference(String refNo) {
//        List<SignVo> signApprovalVoListForReference = mapper.getSignApprovalListForReference(refNo);
//        if(signApprovalVoListForReference == null){
//            throw new RuntimeException("[S-015] SIGN APPROVAL LIST FOR REFERENCE SELECT ERROR");
//        }
//        return signApprovalVoListForReference;
//    } // getSignApprovalListForReference
//
//    // 결재 반려 목록 조회 (참조자 입장) (API)
//    public List<SignVo> getSignReturnListForReference(String refNo) {
//        List<SignVo> signReturnVoListForReference = mapper.getSignReturnListForReference(refNo);
//        if(signReturnVoListForReference == null){
//            throw new RuntimeException("[S-016] SIGN RETURN LIST FOR REFERENCE SELECT ERROR");
//        }
//        return signReturnVoListForReference;
//    } // getSignReturnListForReference
//
//    // 결재 전체 목록 조회 (참조자 입장) (API)
//    public List<SignVo> getSignListForReference(String refNo) {
//        List<SignVo> signVoListForReference = mapper.getSignListForReference(refNo);
//        if(signVoListForReference == null){
//            throw new RuntimeException("[S-017] SIGN LIST FOR REFERENCE SELECT ERROR");
//        }
//        return signVoListForReference;
//    } // getSignListForReference
} // class
