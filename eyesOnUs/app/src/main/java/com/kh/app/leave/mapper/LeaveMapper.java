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
    @Insert("INSERT INTO LEAVE(\n" +
            "    NO, TYPE_NO, EMP_NO, APPROVER_NO\n" +
            "    , START_DATE, END_DATE\n" +
            "    , REASON\n" +
            ")\n" +
            "VALUES(\n" +
            "    SEQ_LEAVE.NEXTVAL, #{typeNo}, #{empNo}, #{approverNo}\n" +
            "    , #{startDate}, #{endDate}\n" +
            "    , #{reason}\n" +
            ")"
    )
    int leaveWrite(LeaveVo vo);

    // 휴가 상세 조회 (API)
    @Select("SELECT\n" +
            "    L.NO\n" +
            "    , L.TYPE_NO         LEAVE_TYPE\n" +
            "    , A.NAME            LEAVE_NAME\n" +
            "    , L.EMP_NO\n" +
            "    , L.APPROVER_NO\n" +
            "    , L.START_DATE\n" +
            "    , L.END_DATE\n" +
            "    , L.REASON\n" +
            "    , L.STATE\n" +
            "    , E.NAME            EMP_NAME\n" +
            "    , E.NICK\n" +
            "    , D.CODE            DIV_CODE\n" +
            "    , D.NAME            DIV_NAME\n" +
            "    , P.CODE            POSITION_CODE\n" +
            "    , P.NAME            POSITION_NAME\n" +
            "    , T.CODE            DEPT_CODE\n" +
            "    , T.NAME            DEPT_NAME\n" +
            "FROM LEAVE L\n" +
            "JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)\n" +
            "JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
            "JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
            "JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
            "JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)\n" +
            "WHERE L.NO = #{leaveNo}")
    LeaveVo getLeaveDetail(@RequestParam("leaveNo") String leaveNo);

    // 휴가 승인자 상세 조회 (API)
    @Select("SELECT\n" +
            "    L.NO\n" +
            "    , L.APPROVER_NO\n" +
            "    , E.NAME            APPROVER_NAME\n" +
            "    , E.NICK\n" +
            "    , D.CODE            DIV_CODE\n" +
            "    , D.NAME            DIV_NAME\n" +
            "    , P.CODE            POSITION_CODE\n" +
            "    , P.NAME            POSITION_NAME\n" +
            "    , T.CODE            DEPT_CODE\n" +
            "    , T.NAME            DEPT_NAME\n" +
            "FROM LEAVE L\n" +
            "JOIN EMPLOYEE E ON (L.APPROVER_NO = E.NO)\n" +
            "JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
            "JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
            "JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
            "WHERE L.NO = #{leaveNo}")
    LeaveVo getLeaveApproverDetail(@RequestParam("leaveNo") String leaveNo);

    // 휴가 승인자 목록 조회 (API)
    @Select("SELECT\n" +
            "    ROWNUM\n" +
            "    , Y.NO\n" +
            "    , Y.APPROVER_NO\n" +
            "    , Y.APPROVER_NAME\n" +
            "    , Y.NICK\n" +
            "    , Y.DIV_CODE\n" +
            "    , Y.DIV_NAME\n" +
            "    , Y.POSITION_CODE\n" +
            "    , Y.POSITION_NAME\n" +
            "    , Y.DEPT_CODE\n" +
            "    , Y.DEPT_NAME\n" +
            "FROM\n" +
            "(\n" +
            "    SELECT\n" +
            "        L.NO\n" +
            "        , L.APPROVER_NO\n" +
            "        , E.NAME            APPROVER_NAME\n" +
            "        , E.NICK\n" +
            "        , D.CODE            DIV_CODE\n" +
            "        , D.NAME            DIV_NAME\n" +
            "        , P.CODE            POSITION_CODE\n" +
            "        , P.NAME            POSITION_NAME\n" +
            "        , T.CODE            DEPT_CODE\n" +
            "        , T.NAME            DEPT_NAME\n" +
            "    FROM LEAVE L\n" +
            "    JOIN EMPLOYEE E ON (L.APPROVER_NO = E.NO)\n" +
            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
            "    WHERE L.EMP_NO = #{empNo}\n" +
            "    ORDER BY L.NO DESC\n" +
            ") Y")
    List<LeaveVo> getLeaveApproverList(@RequestParam("empNo") String empNo);

    // 휴가 승인 (API)
    @Update("UPDATE LEAVE\n" +
            "SET STATE = #{state}\n" +
            "WHERE NO = #{no}")
    int updateLeaveApprove(LeaveVo leaveVo);

    // 휴가 목록 조회 (동적 쿼리) (API)
    @Select({
            "<script>",
                "SELECT",
                    "ROWNUM",
                    ", Y.NO",
                    ", Y.LEAVE_TYPE",
                    ", Y.LEAVE_NAME",
                    ", Y.EMP_NO",
                    ", Y.APPROVER_NO",
                    ", Y.START_DATE",
                    ", Y.END_DATE",
                    ", Y.REASON",
                    ", Y.STATE",
                    ", Y.EMP_NAME",
                    ", Y.NICK",
                    ", Y.DIV_CODE",
                    ", Y.DIV_NAME",
                    ", Y.POSITION_CODE",
                    ", Y.POSITION_NAME",
                    ", Y.DEPT_CODE",
                    ", Y.DEPT_NAME",
                "FROM",
                "(",
                    "SELECT",
                        "L.NO",
                        ", L.TYPE_NO LEAVE_TYPE",
                        ", A.NAME LEAVE_NAME",
                        ", L.EMP_NO",
                        ", L.APPROVER_NO",
                        ", L.START_DATE",
                        ", L.END_DATE",
                        ", L.REASON",
                        ", L.STATE",
                        ", E.NAME EMP_NAME",
                        ", E.NICK",
                        ", D.CODE DIV_CODE",
                        ", D.NAME DIV_NAME",
                        ", P.CODE POSITION_CODE",
                        ", P.NAME POSITION_NAME",
                        ", T.CODE DEPT_CODE",
                        ", T.NAME DEPT_NAME",
                    "FROM LEAVE L",
                    "JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)",
                    "JOIN DIVISION D ON (E.DIV_CODE = D.CODE)",
                    "JOIN POSITION P ON (E.POSITION_CODE = P.CODE)",
                    "JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)",
                    "JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)",

                    "<if test='empNo != null'>",
                        "WHERE L.EMP_NO = #{empNo}",
                    "</if>",

                    "<if test='approverNo != null'>",
                        "WHERE L.APPROVER_NO = #{approverNo}",
                    "</if>",

                    "<if test='state != null'>",
                        "AND L.STATE = #{state}",
                    "</if>",

                    "ORDER BY L.NO DESC",
                ") Y",
            "</script>"
    })
    List<LeaveVo> getLeaveListForAll(LeaveVo vo);

//    // 휴가 승인 대기 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.LEAVE_TYPE\n" +
//            "    , Y.LEAVE_NAME\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.STATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        L.NO\n" +
//            "        , L.TYPE_NO         LEAVE_TYPE\n" +
//            "        , A.NAME            LEAVE_NAME\n" +
//            "        , L.EMP_NO\n" +
//            "        , L.APPROVER_NO\n" +
//            "        , L.START_DATE\n" +
//            "        , L.END_DATE\n" +
//            "        , L.REASON\n" +
//            "        , L.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM LEAVE L\n" +
//            "    JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)\n" +
//            "    WHERE L.EMP_NO = #{empNo}\n" +
//            "    AND L.STATE = 0\n" +
//            "    ORDER BY L.NO DESC\n" +
//            ") Y")
//    List<LeaveVo> getLeaveWaitList(@RequestParam("empNo") String empNo);
//
//    // 휴가 승인 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.LEAVE_TYPE\n" +
//            "    , Y.LEAVE_NAME\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.STATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        L.NO\n" +
//            "        , L.TYPE_NO         LEAVE_TYPE\n" +
//            "        , A.NAME            LEAVE_NAME\n" +
//            "        , L.EMP_NO\n" +
//            "        , L.APPROVER_NO\n" +
//            "        , L.START_DATE\n" +
//            "        , L.END_DATE\n" +
//            "        , L.REASON\n" +
//            "        , L.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM LEAVE L\n" +
//            "    JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)\n" +
//            "    WHERE L.EMP_NO = #{empNo}\n" +
//            "    AND L.STATE = 1\n" +
//            "    ORDER BY L.NO DESC\n" +
//            ") Y")
//    List<LeaveVo> getLeaveApprovalList(@RequestParam("empNo") String empNo);
//
//    // 휴가 반려 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.LEAVE_TYPE\n" +
//            "    , Y.LEAVE_NAME\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.STATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        L.NO\n" +
//            "        , L.TYPE_NO         LEAVE_TYPE\n" +
//            "        , A.NAME            LEAVE_NAME\n" +
//            "        , L.EMP_NO\n" +
//            "        , L.APPROVER_NO\n" +
//            "        , L.START_DATE\n" +
//            "        , L.END_DATE\n" +
//            "        , L.REASON\n" +
//            "        , L.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM LEAVE L\n" +
//            "    JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)\n" +
//            "    WHERE L.EMP_NO = #{empNo}\n" +
//            "    AND L.STATE = 2\n" +
//            "    ORDER BY L.NO DESC\n" +
//            ") Y")
//    List<LeaveVo> getLeaveReturnList(@RequestParam("empNo") String empNo);
//
//    // 휴가 전체 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.LEAVE_TYPE\n" +
//            "    , Y.LEAVE_NAME\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.STATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        L.NO\n" +
//            "        , L.TYPE_NO         LEAVE_TYPE\n" +
//            "        , A.NAME            LEAVE_NAME\n" +
//            "        , L.EMP_NO\n" +
//            "        , L.APPROVER_NO\n" +
//            "        , L.START_DATE\n" +
//            "        , L.END_DATE\n" +
//            "        , L.REASON\n" +
//            "        , L.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM LEAVE L\n" +
//            "    JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)\n" +
//            "    WHERE L.EMP_NO = #{empNo}\n" +
//            "    ORDER BY L.NO DESC\n" +
//            ") Y")
//    List<LeaveVo> getLeaveList(@RequestParam("empNo") String empNo);
//
//    // 휴가 승인 대기 목록 조회 (승인자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.LEAVE_TYPE\n" +
//            "    , Y.LEAVE_NAME\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.STATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        L.NO\n" +
//            "        , L.TYPE_NO         LEAVE_TYPE\n" +
//            "        , A.NAME            LEAVE_NAME\n" +
//            "        , L.EMP_NO\n" +
//            "        , L.APPROVER_NO\n" +
//            "        , L.START_DATE\n" +
//            "        , L.END_DATE\n" +
//            "        , L.REASON\n" +
//            "        , L.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM LEAVE L\n" +
//            "    JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)\n" +
//            "    WHERE L.APPROVER_NO = #{approverNo}\n" +
//            "    AND L.STATE = 0" +
//            "    ORDER BY L.NO DESC\n" +
//            ") Y")
//    List<LeaveVo> getLeaveWaitListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 휴가 승인 목록 조회 (승인자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.LEAVE_TYPE\n" +
//            "    , Y.LEAVE_NAME\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.STATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        L.NO\n" +
//            "        , L.TYPE_NO         LEAVE_TYPE\n" +
//            "        , A.NAME            LEAVE_NAME\n" +
//            "        , L.EMP_NO\n" +
//            "        , L.APPROVER_NO\n" +
//            "        , L.START_DATE\n" +
//            "        , L.END_DATE\n" +
//            "        , L.REASON\n" +
//            "        , L.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM LEAVE L\n" +
//            "    JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)\n" +
//            "    WHERE L.APPROVER_NO = #{approverNo}\n" +
//            "    AND L.STATE = 1" +
//            "    ORDER BY L.NO DESC\n" +
//            ") Y")
//    List<LeaveVo> getLeaveApprovalListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 휴가 반려 목록 조회 (승인자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.LEAVE_TYPE\n" +
//            "    , Y.LEAVE_NAME\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.STATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        L.NO\n" +
//            "        , L.TYPE_NO         LEAVE_TYPE\n" +
//            "        , A.NAME            LEAVE_NAME\n" +
//            "        , L.EMP_NO\n" +
//            "        , L.APPROVER_NO\n" +
//            "        , L.START_DATE\n" +
//            "        , L.END_DATE\n" +
//            "        , L.REASON\n" +
//            "        , L.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM LEAVE L\n" +
//            "    JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)\n" +
//            "    WHERE L.APPROVER_NO = #{approverNo}\n" +
//            "    AND L.STATE = 2" +
//            "    ORDER BY L.NO DESC\n" +
//            ") Y")
//    List<LeaveVo> getLeaveReturnListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 휴가 전체 목록 조회 (승인자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.LEAVE_TYPE\n" +
//            "    , Y.LEAVE_NAME\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.STATE\n" +
//            "    , Y.EMP_NAME\n" +
//            "    , Y.NICK\n" +
//            "    , Y.DIV_CODE\n" +
//            "    , Y.DIV_NAME\n" +
//            "    , Y.POSITION_CODE\n" +
//            "    , Y.POSITION_NAME\n" +
//            "    , Y.DEPT_CODE\n" +
//            "    , Y.DEPT_NAME\n" +
//            "FROM\n" +
//            "(\n" +
//            "    SELECT\n" +
//            "        L.NO\n" +
//            "        , L.TYPE_NO         LEAVE_TYPE\n" +
//            "        , A.NAME            LEAVE_NAME\n" +
//            "        , L.EMP_NO\n" +
//            "        , L.APPROVER_NO\n" +
//            "        , L.START_DATE\n" +
//            "        , L.END_DATE\n" +
//            "        , L.REASON\n" +
//            "        , L.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM LEAVE L\n" +
//            "    JOIN EMPLOYEE E ON (L.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    JOIN LEAVE_TYPE A ON (L.TYPE_NO = A.NO)\n" +
//            "    WHERE L.APPROVER_NO = #{approverNo}\n" +
//            "    ORDER BY L.NO DESC\n" +
//            ") Y")
//    List<LeaveVo> getLeaveListForApprover(@RequestParam("approverNo") String approverNo);
} // interface
