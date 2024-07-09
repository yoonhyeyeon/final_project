package com.kh.app.businessTrip.mapper;

import com.kh.app.businessTrip.vo.BusinessTripVo;
import com.kh.app.businessTrip.vo.ProjectVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface BusinessTripMapper {

    // 출장 신청
    @Insert({"""
            INSERT INTO BUSINESS_TRIP(
                NO, PRO_NO, EMP_NO, APPROVER_NO
                , START_DATE, END_DATE
                , REASON, DESTINATION
            )
            VALUES(
                SEQ_BUSINESS_TRIP.NEXTVAL, #{proNo}, #{empNo}, #{approverNo}
                , #{startDate}, #{endDate}
                , #{reason}, #{destination}
            )
            """})
    int businessTripWrite(BusinessTripVo vo);

    // 출장 목록 조회 (신청자 입장) (API)
    @Select("""
            SELECT
                B.NO
                , B.PRO_NO          PRO_CODE
                , J.TITLE           PRO_NAME
                , B.EMP_NO
                , B.APPROVER_NO
                , B.ENROLL_DATE
                , B.APPROVE_DATE
                , B.START_DATE
                , B.END_DATE
                , B.REASON
                , B.DESTINATION
                , B.STATE
                , E.NAME            EMP_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM BUSINESS_TRIP B
            JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            JOIN PROJECT J ON (B.PRO_NO = J.NO) 
            WHERE B.EMP_NO = #{empNo}
            ORDER BY B.NO DESC
            """)
    List<BusinessTripVo> getBusinessTripListForWriter(@RequestParam("empNo") String empNo);

    // 출장 승인자 목록 조회 (신청자 입장) (API)
    @Select("""
            SELECT
                B.NO
                , B.APPROVER_NO
                , E.NAME            APPROVER_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM BUSINESS_TRIP B
            JOIN EMPLOYEE E ON (APPROVER_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE B.EMP_NO = #{empNo}
            ORDER BY B.NO DESC
            """)
    List<BusinessTripVo> getBusinessTripApproverListForWriter(@RequestParam("empNo") String empNo);

    // 출장 목록 조회 (승인자 입장) (API)
    @Select({"""
            SELECT
                B.NO
                , B.PRO_NO          PRO_CODE
                , J.TITLE           PRO_NAME
                , B.EMP_NO
                , B.APPROVER_NO
                , B.ENROLL_DATE
                , B.APPROVE_DATE
                , B.START_DATE
                , B.END_DATE
                , B.REASON
                , B.DESTINATION
                , B.STATE
                , E.NAME            EMP_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM BUSINESS_TRIP B
            JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            JOIN PROJECT J ON (B.PRO_NO = J.NO)
            WHERE B.APPROVER_NO = #{approverNo}
            ORDER BY B.NO DESC
            """})
    List<BusinessTripVo> getBusinessTripListForApprover(@RequestParam("approverNo") String approverNo);

    // 출장 승인자 목록 조회 (승인자 입장) (API)
    @Select({"""
            SELECT
                B.NO
                , B.APPROVER_NO
                , E.NAME            APPROVER_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM BUSINESS_TRIP B
            JOIN EMPLOYEE E ON (APPROVER_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE B.APPROVER_NO = #{approverNo}
            ORDER BY B.NO DESC
            """})
    List<BusinessTripVo> getBusinessTripApproverListForApprover(@RequestParam("approverNo") String approverNo);

    // 출장 상세 조회 (API)
    @Select({"""
            SELECT
                B.NO
                , B.PRO_NO          PRO_CODE
                , J.TITLE           PRO_NAME
                , B.EMP_NO
                , B.APPROVER_NO
                , B.START_DATE
                , B.END_DATE
                , B.REASON
                , B.DESTINATION
                , B.STATE
                , B.ENROLL_DATE
                , B.APPROVE_DATE
                , E.NAME            EMP_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM BUSINESS_TRIP B
            JOIN EMPLOYEE E ON (B.EMP_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            JOIN PROJECT J ON (B.PRO_NO = J.NO)
            WHERE B.NO = #{businessTripNo}
            """})
    BusinessTripVo getBusinessTripDetail(@RequestParam("businessTripNo") String businessTripNo);

    // 출장 승인자 상세 조회 (API)
    @Select({"""
            SELECT
                B.NO
                , B.APPROVER_NO
                , E.NAME            APPROVER_NAME
                , E.NICK
                , D.CODE            DIV_CODE
                , D.NAME            DIV_NAME
                , P.CODE            POSITION_CODE
                , P.NAME            POSITION_NAME
                , T.CODE            DEPT_CODE
                , T.NAME            DEPT_NAME
            FROM BUSINESS_TRIP B
            JOIN EMPLOYEE E ON (B.APPROVER_NO = E.NO)
            JOIN DIVISION D ON (E.DIV_CODE = D.CODE)
            JOIN POSITION P ON (E.POSITION_CODE = P.CODE)
            JOIN DEPARTMENT T ON (D.DEPT_CODE = T.CODE)
            WHERE B.NO = #{businessTripNo}
            """})
    BusinessTripVo getBusinessTripApproverDetail(@RequestParam("businessTripNo") String businessTripNo);

    // 출장 승인 (API)
    @Update({"""
            UPDATE BUSINESS_TRIP
            SET STATE = #{state}
                , APPROVE_DATE = SYSDATE
            WHERE NO = #{no}
            """})
    int updateBusinessTripApprove(BusinessTripVo businessTripVo);

    // 프로젝트 목록 조회 (API)
    @Select({"""
            SELECT
                J.NO
                , J.CODE
                , J.EMP_NO
                , J.STATE_A_NO
                , J.TITLE
                , J.CONTENT
                , J.START_DATE
                , J.END_DATE
                , J.MODIFY_DATE
            FROM EMPLOYEE E
            JOIN PROJECT_MANAGER M ON (E.NO = M.EMP_NO)
            JOIN PROJECT J ON (M.PRO_NO = J.NO)
            WHERE E.NO = #{empNo}
            """})
    List<ProjectVo> getProjectList(@RequestParam("empNo") String empNo);
} // interface
