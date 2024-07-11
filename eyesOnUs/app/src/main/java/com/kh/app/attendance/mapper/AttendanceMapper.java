package com.kh.app.attendance.mapper;

import com.kh.app.home.vo.CommuteVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttendanceMapper {

    @Select("""
            SELECT
                C.EMP_NO
                , E.NAME AS EMP
                , D.NAME AS DIVISION
                , P.NAME AS POSITION
                , TO_CHAR(C.WORK_TIME, 'YY/MM/DD') AS WORK_DATE
                , TO_CHAR(C.WORK_TIME, 'Dy') AS WORK_DAY
                , TO_CHAR(C.WORK_TIME, 'HH24:MI') AS WORK_TIME
                , TO_CHAR(C.QUIT_TIME, 'HH24:MI') AS QUIT_TIME
                , EXTRACT(HOUR FROM (C.QUIT_TIME - C.WORK_TIME)) AS TOTAL_HOURS
                , EXTRACT(MINUTE FROM (C.QUIT_TIME - C.WORK_TIME)) AS TOTAL_MINUTES
                , A.NAME AS ATTEND
            FROM COMMUTE C
            JOIN EMPLOYEE E
            ON C.EMP_NO = E.NO
            JOIN DIVISION D
            ON E.DEPT_CODE = D.CODE
            JOIN POSITION P
            ON E.POSITION_CODE = P.CODE
            JOIN ATTEND A
            ON E.STATE = A.STATE
            WHERE C.EMP_NO = #{empNo}
            """)
    List<CommuteVo> list(String empNo);

    @Select("SELECT * FROM COMMUTE")
    List<CommuteVo> listVo(CommuteVo vo);

    @Select("""
            SELECT
                C.EMP_NO
                , E.NAME AS EMP
                , D.NAME AS DIVISION
                , P.NAME AS POSITION
            FROM COMMUTE C
            JOIN EMPLOYEE E
            ON C.EMP_NO = E.NO
            JOIN DIVISION D
            ON E.DEPT_CODE = D.CODE
            JOIN POSITION P
            ON E.POSITION_CODE = P.CODE
            WHERE C.EMP_NO = #{empNo}
            """)
    CommuteVo noDate(String empNo);

}
