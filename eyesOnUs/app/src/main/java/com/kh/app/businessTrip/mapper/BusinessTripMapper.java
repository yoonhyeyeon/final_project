package com.kh.eyes.businessTrip.mapper;

import com.kh.eyes.businessTrip.vo.BusinessTripVo;
import com.kh.eyes.businessTrip.vo.ProjectVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface BusinessTripMapper {
    
    // 출장 신청
    @Insert("INSERT INTO BUSINESS_TRIP(\n" +
            "   NO, PRO_NO, EMP_NO, APPROVER_NO\n" +
            "   , START_DATE, END_DATE\n" +
            "   , REASON, DESTINATION\n" +
            ")\n" +
            "VALUES(\n" +
            "   SEQ_BUSINESS_TRIP.NEXTVAL, #{proNo}, #{empNo}, #{approverNo}\n" +
            "   , #{startDate}, #{endDate}\n" +
            "   , #{reason}, #{destination}\n" +
            ")")
    int businessTripWrite(BusinessTripVo vo);

    // 출장 상세 조회 (API)
    @Select("SELECT\n" +
            "    B.NO\n" +
            "    , B.PRO_NO\n" +
            "    , B.EMP_NO\n" +
            "    , B.APPROVER_NO\n" +
            "    , B.START_DATE\n" +
            "    , B.END_DATE\n" +
            "    , B.REASON\n" +
            "    , B.DESTINATION\n" +
            "    , B.STATE\n" +
            "    , E.NAME            EMP_NAME\n" +
            "    , E.NICK\n" +
            "    , D.CODE            DIV_CODE\n" +
            "    , D.NAME            DIV_NAME\n" +
            "    , P.CODE            POSITION_CODE\n" +
            "    , P.NAME            POSITION_NAME\n" +
            "    , T.CODE            DEPT_CODE\n" +
            "    , T.NAME            DEPT_NAME\n" +
            "FROM BUSINESS_TRIP B\n" +
            "JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)\n" +
            "JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
            "JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
            "JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
            "WHERE B.NO = #{businessTripNo}")
    BusinessTripVo getBusinessTripDetail(@RequestParam("businessTripNo") String businessTripNo);

    // 출장 승인자 상세 조회 (API)
    @Select("SELECT\n" +
            "    B.NO\n" +
            "    , B.APPROVER_NO\n" +
            "    , E.NAME            APPROVER_NAME\n" +
            "    , E.NICK\n" +
            "    , D.CODE            DIV_CODE\n" +
            "    , D.NAME            DIV_NAME\n" +
            "    , P.CODE            POSITION_CODE\n" +
            "    , P.NAME            POSITION_NAME\n" +
            "    , T.CODE            DEPT_CODE\n" +
            "    , T.NAME            DEPT_NAME\n" +
            "FROM BUSINESS_TRIP B\n" +
            "JOIN EMPLOYEE E ON (B.APPROVER_NO = E.NO)\n" +
            "JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
            "JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
            "JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
            "WHERE B.NO = #{businessTripNo}")
    BusinessTripVo getBusinessTripApproverDetail(@RequestParam("businessTripNo") String businessTripNo);

    // 출장 승인자 목록 조회 (API)
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
            "        B.NO\n" +
            "        , B.APPROVER_NO\n" +
            "        , E.NAME            APPROVER_NAME\n" +
            "        , E.NICK\n" +
            "        , D.CODE            DIV_CODE\n" +
            "        , D.NAME            DIV_NAME\n" +
            "        , P.CODE            POSITION_CODE\n" +
            "        , P.NAME            POSITION_NAME\n" +
            "        , T.CODE            DEPT_CODE\n" +
            "        , T.NAME            DEPT_NAME\n" +
            "    FROM BUSINESS_TRIP B\n" +
            "    JOIN EMPLOYEE E ON (B.APPROVER_NO = E.NO)\n" +
            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
            "    WHERE B.EMP_NO = #{businessTripNo}\n" +
            "    ORDER BY B.NO DESC\n" +
            ") Y")
    List<BusinessTripVo> getBusinessTripApproverList(@RequestParam("businessTripNo") String empNo);

    // 출장 승인 (API)
    @Update("UPDATE BUSINESS_TRIP\n" +
            "SET STATE = #{state}\n" +
            "WHERE NO = #{no}")
    int updateBusinessTripApprove(BusinessTripVo businessTripVo);

    // 프로젝트 목록 조회 (API)
    @Select("SELECT\n" +
            "    ROWNUM\n" +
            "    , NO\n" +
            "    , CODE\n" +
            "    , EMP_NO\n" +
            "    , STATE_A_NO\n" +
            "    , CONTENT\n" +
            "    , START_DATE\n" +
            "    , END_DATE\n" +
            "    , MODIFY_DATE\n" +
            "FROM PROJECT")
    List<ProjectVo> getProjectList();

    // 출장 목록 조회 (동적 쿼리) (API)
    @Select({
            "<script>",
                "SELECT",
                    "ROWNUM",
                    ", Y.NO",
                    ", Y.PRO_NO",
                    ", Y.EMP_NO",
                    ", Y.APPROVER_NO",
                    ", Y.START_DATE",
                    ", Y.END_DATE",
                    ", Y.REASON",
                    ", Y.DESTINATION",
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
                        "B.NO",
                        ", B.PRO_NO",
                        ", B.EMP_NO",
                        ", B.APPROVER_NO",
                        ", B.START_DATE",
                        ", B.END_DATE",
                        ", B.REASON",
                        ", B.DESTINATION",
                        ", B.STATE",
                        ", E.NAME EMP_NAME",
                        ", E.NICK",
                        ", D.CODE DIV_CODE",
                        ", D.NAME DIV_NAME",
                        ", P.CODE POSITION_CODE",
                        ", P.NAME POSITION_NAME",
                        ", T.CODE DEPT_CODE",
                        ", T.NAME DEPT_NAME",
                    "FROM BUSINESS_TRIP B",
                    "JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)",
                    "JOIN DIVISION D ON (E.DIV_CODE = D.CODE)",
                    "JOIN POSITION P ON (E.POSITION_CODE = P.CODE)",
                    "JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)",

                    "<if test='empNo != null'>",
                        "WHERE B.EMP_NO = #{empNo}",
                    "</if>",

                    "<if test='approverNo != null'>",
                        "WHERE B.APPROVER_NO = #{approverNo}",
                    "</if>",

                    "<if test='state != null'>",
                        "AND B.STATE = #{state}",
                    "</if>",

                    "ORDER BY B.NO DESC",
                ") Y",
            "</script>"
    })
    List<BusinessTripVo> getBusinessTripListForAll(BusinessTripVo businessTripVo);

//    // 출장 승인 진행 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.PRO_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.DESTINATION\n" +
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
//            "        B.NO\n" +
//            "        , B.PRO_NO\n" +
//            "        , B.EMP_NO\n" +
//            "        , B.APPROVER_NO\n" +
//            "        , B.START_DATE\n" +
//            "        , B.END_DATE\n" +
//            "        , B.REASON\n" +
//            "        , B.DESTINATION\n" +
//            "        , B.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM BUSINESS_TRIP B\n" +
//            "    JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE B.EMP_NO = #{empNo}\n" +
//            "    AND B.STATE = 0" +
//            "    ORDER BY B.NO DESC\n" +
//            ") Y")
//    List<BusinessTripVo> getBusinessTripWaitList(@RequestParam("empNo") String empNo);
//
//    // 출장 승인 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.PRO_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.DESTINATION\n" +
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
//            "        B.NO\n" +
//            "        , B.PRO_NO\n" +
//            "        , B.EMP_NO\n" +
//            "        , B.APPROVER_NO\n" +
//            "        , B.START_DATE\n" +
//            "        , B.END_DATE\n" +
//            "        , B.REASON\n" +
//            "        , B.DESTINATION\n" +
//            "        , B.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM BUSINESS_TRIP B\n" +
//            "    JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE B.EMP_NO = #{empNo}\n" +
//            "    AND B.STATE = 1" +
//            "    ORDER BY B.NO DESC\n" +
//            ") Y")
//    List<BusinessTripVo> getBusinessTripApprovalList(@RequestParam("empNo") String empNo);
//
//    // 출장 반려 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.PRO_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.DESTINATION\n" +
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
//            "        B.NO\n" +
//            "        , B.PRO_NO\n" +
//            "        , B.EMP_NO\n" +
//            "        , B.APPROVER_NO\n" +
//            "        , B.START_DATE\n" +
//            "        , B.END_DATE\n" +
//            "        , B.REASON\n" +
//            "        , B.DESTINATION\n" +
//            "        , B.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM BUSINESS_TRIP B\n" +
//            "    JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE B.EMP_NO = #{empNo}\n" +
//            "    AND B.STATE = 2" +
//            "    ORDER BY B.NO DESC\n" +
//            ") Y")
//    List<BusinessTripVo> getBusinessTripReturnList(@RequestParam("empNo") String empNo);
//
//    // 출장 전체 목록 조회 (신청자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.PRO_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.DESTINATION\n" +
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
//            "        B.NO\n" +
//            "        , B.PRO_NO\n" +
//            "        , B.EMP_NO\n" +
//            "        , B.APPROVER_NO\n" +
//            "        , B.START_DATE\n" +
//            "        , B.END_DATE\n" +
//            "        , B.REASON\n" +
//            "        , B.DESTINATION\n" +
//            "        , B.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM BUSINESS_TRIP B\n" +
//            "    JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE B.EMP_NO = #{empNo}\n" +
//            "    ORDER BY B.NO DESC\n" +
//            ") Y")
//    List<BusinessTripVo> getBusinessTripList(@RequestParam("empNo") String empNo);
//
//    // 출장 승인 진행 목록 조회 (승인자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.PRO_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.DESTINATION\n" +
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
//            "        B.NO\n" +
//            "        , B.PRO_NO\n" +
//            "        , B.EMP_NO\n" +
//            "        , B.APPROVER_NO\n" +
//            "        , B.START_DATE\n" +
//            "        , B.END_DATE\n" +
//            "        , B.REASON\n" +
//            "        , B.DESTINATION\n" +
//            "        , B.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM BUSINESS_TRIP B\n" +
//            "    JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE B.APPROVER_NO = #{approverNo}\n" +
//            "    AND B.STATE = 0" +
//            "    ORDER BY B.NO DESC\n" +
//            ") Y")
//    List<BusinessTripVo> getBusinessTripWaitListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 출장 승인 목록 조회 (승인자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.PRO_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.DESTINATION\n" +
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
//            "        B.NO\n" +
//            "        , B.PRO_NO\n" +
//            "        , B.EMP_NO\n" +
//            "        , B.APPROVER_NO\n" +
//            "        , B.START_DATE\n" +
//            "        , B.END_DATE\n" +
//            "        , B.REASON\n" +
//            "        , B.DESTINATION\n" +
//            "        , B.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM BUSINESS_TRIP B\n" +
//            "    JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE B.APPROVER_NO = #{approverNo}" +
//            "    AND B.STATE = 1\n" +
//            "    ORDER BY B.NO DESC\n" +
//            ") Y")
//    List<BusinessTripVo> getBusinessTripApprovalListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 출장 반려 목록 조회 (승인자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.PRO_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.DESTINATION\n" +
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
//            "        B.NO\n" +
//            "        , B.PRO_NO\n" +
//            "        , B.EMP_NO\n" +
//            "        , B.APPROVER_NO\n" +
//            "        , B.START_DATE\n" +
//            "        , B.END_DATE\n" +
//            "        , B.REASON\n" +
//            "        , B.DESTINATION\n" +
//            "        , B.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM BUSINESS_TRIP B\n" +
//            "    JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE B.APPROVER_NO = #{approverNo}\n" +
//            "    AND B.STATE = 2" +
//            "    ORDER BY B.NO DESC\n" +
//            ") Y")
//    List<BusinessTripVo> getBusinessTripReturnListForApprover(@RequestParam("approverNo") String approverNo);
//
//    // 출장 전체 목록 조회 (승인자 입장) (API)
//    @Select("SELECT\n" +
//            "    ROWNUM\n" +
//            "    , Y.NO\n" +
//            "    , Y.PRO_NO\n" +
//            "    , Y.EMP_NO\n" +
//            "    , Y.APPROVER_NO\n" +
//            "    , Y.START_DATE\n" +
//            "    , Y.END_DATE\n" +
//            "    , Y.REASON\n" +
//            "    , Y.DESTINATION\n" +
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
//            "        B.NO\n" +
//            "        , B.PRO_NO\n" +
//            "        , B.EMP_NO\n" +
//            "        , B.APPROVER_NO\n" +
//            "        , B.START_DATE\n" +
//            "        , B.END_DATE\n" +
//            "        , B.REASON\n" +
//            "        , B.DESTINATION\n" +
//            "        , B.STATE\n" +
//            "        , E.NAME            EMP_NAME\n" +
//            "        , E.NICK\n" +
//            "        , D.CODE            DIV_CODE\n" +
//            "        , D.NAME            DIV_NAME\n" +
//            "        , P.CODE            POSITION_CODE\n" +
//            "        , P.NAME            POSITION_NAME\n" +
//            "        , T.CODE            DEPT_CODE\n" +
//            "        , T.NAME            DEPT_NAME\n" +
//            "    FROM BUSINESS_TRIP B\n" +
//            "    JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)\n" +
//            "    JOIN DIVISION D ON (E.DIV_CODE = D.CODE)\n" +
//            "    JOIN POSITION P ON (E.POSITION_CODE = P.CODE)\n" +
//            "    JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)\n" +
//            "    WHERE B.APPROVER_NO = #{approverNo}\n" +
//            "    ORDER BY B.NO DESC\n" +
//            ") Y")
//    List<BusinessTripVo> getBusinessTripListForApprover(@RequestParam("approverNo") String approverNo);
} // interface
