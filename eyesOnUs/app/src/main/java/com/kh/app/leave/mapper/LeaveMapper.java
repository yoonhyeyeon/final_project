package com.kh.app.leave.mapper;

import com.kh.app.leave.vo.LeaveVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface LeaveMapper {

    // 휴가 신청
    @Insert({"""
            INSERT INTO LEAVE(
                NO, TYPE_NO, EMP_NO, APPROVER_NO
                , START_DATE, END_DATE
                , REASON
            )
            VALUES(
                SEQ_LEAVE.NEXTVAL, #{typeNo}, #{empNo}, #{approverNo}
                , #{startDate}, #{endDate}
                , #{reason}
            )
            """})
    int leaveWrite(LeaveVo vo);

    // 휴가 목록 조회 (신청자 입장) (API)
    @Select({"""
            SELECT
                L.NO
                , L.TYPE_NO         LEAVE_TYPE
                , A.NAME            LEAVE_NAME
                , L.EMP_NO
                , L.ENROLL_DATE
                , L.APPROVE_DATE
                , L.APPROVER_NO
                , L.START_DATE
                , L.END_DATE
                , L.REASON
                , L.STATE
                , E.NAME            EMP_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM LEAVE L
            JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)
            WHERE L.EMP_NO = #{empNo}
            ORDER BY L.NO DESC
            """})
    List<LeaveVo> getLeaveListForWriter(@RequestParam("empNo") String empNo);

    // 휴가 승인자 목록 조회 (신청자 입장) (API)
    @Select({"""
            SELECT
                L.NO
                , L.APPROVER_NO
                , E.NAME            APPROVER_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM LEAVE L
            JOIN EMPLOYEE E ON (L.APPROVER_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE L.EMP_NO = #{empNo}
            ORDER BY L.NO DESC
            """})
    List<LeaveVo> getLeaveApproverListForWriter(@RequestParam("empNo") String empNo);

    // 휴가 목록 조회 (승인자 입장) (API)
    @Select({"""
            SELECT
                L.NO
                , L.TYPE_NO         LEAVE_TYPE
                , A.NAME            LEAVE_NAME
                , L.EMP_NO
                , L.ENROLL_DATE
                , L.APPROVE_DATE
                , L.APPROVER_NO
                , L.START_DATE
                , L.END_DATE
                , L.REASON
                , L.STATE
                , E.NAME            EMP_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM LEAVE L
            JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)
            WHERE L.APPROVER_NO = #{approverNo}
            ORDER BY L.NO DESC
            """})
    List<LeaveVo> getLeaveListForApprover(@RequestParam("approverNo") String approverNo);

    // 휴가 승인자 목록 조회 (승인자 입장) (API)
    @Select({"""
            SELECT
                L.NO
                , L.APPROVER_NO
                , E.NAME            APPROVER_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM LEAVE L
            JOIN EMPLOYEE E ON (L.APPROVER_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE L.APPROVER_NO = #{approverNo}
            ORDER BY L.NO DESC
            """})
    List<LeaveVo> getLeaveApproverListForApprover(@RequestParam("approverNo") String approverNo);

    // 휴가 상세 조회 (API)
    @Select({"""
            SELECT
                L.NO
                , L.TYPE_NO         LEAVE_TYPE
                , A.NAME            LEAVE_NAME
                , L.EMP_NO
                , L.APPROVER_NO
                , L.START_DATE
                , L.END_DATE
                , L.REASON
                , L.STATE
                , L.ENROLL_DATE
                , L.APPROVE_DATE
                , E.NAME            EMP_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM LEAVE L
            JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)
            WHERE L.NO = #{no}
            """})
    LeaveVo getLeaveDetail(LeaveVo leaveVo);

    // 휴가 승인자 상세 조회 (API)
    @Select({"""
            SELECT
                L.NO
                , L.APPROVER_NO
                , E.NAME            APPROVER_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM LEAVE L
            JOIN EMPLOYEE E ON (L.APPROVER_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE L.NO = #{no}
            """})
    LeaveVo getLeaveApproverDetail(LeaveVo leaveVo);


    // 휴가 승인 (API)
    @Update({"""
            UPDATE LEAVE
            SET STATE = #{state}
                , APPROVE_DATE = SYSDATE
            WHERE NO = #{no}
            """})
    int updateLeaveApprove(LeaveVo leaveVo);

    // 휴가 타입 리스트 (API)
    @Select("""
            SELECT
                NO          LEAVE_TYPE
                , NAME      LEAVE_NAME
            FROM LEAVE_TYPE
            ORDER BY NO ASC
            """)
    List<LeaveVo> getLeaveTypeList();
} // interface
