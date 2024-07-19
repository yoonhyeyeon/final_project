package com.kh.app.attendance.mapper;

import com.kh.app.home.vo.HomeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttendanceMapper {

    @Select("""
            <script>
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
                , COALESCE(LT.NAME, A.NAME) AS ATTEND
            FROM COMMUTE C
            JOIN EMPLOYEE E
            ON C.EMP_NO = E.NO
            JOIN DIVISION D
            ON E.DEPT_CODE = D.CODE
            JOIN POSITION P
            ON E.POSITION_CODE = P.CODE
            JOIN ATTEND A
            ON E.STATE = A.STATE
            LEFT JOIN LEAVE L
            ON C.EMP_NO = L.EMP_NO
            AND C.WORK_TIME BETWEEN L.START_DATE AND L.END_DATE
            LEFT JOIN LEAVE_TYPE LT
            ON L.TYPE_NO = LT.NO
            WHERE C.EMP_NO = #{empNo}
            <if test="month != null">
                AND TO_CHAR(C.WORK_TIME, 'MM') = #{month}
            </if>
            ORDER BY C.WORK_TIME ASC
            </script>
            """)
    List<HomeVo> list(String empNo, String month);

}