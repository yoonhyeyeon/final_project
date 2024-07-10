package com.kh.app.workTime.mapper;

import com.kh.app.home.vo.CommuteVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorkTimeMapper {

    @Select("""
        SELECT
            NO,
            EMP_NO,
            TO_CHAR(WORK_TIME, 'HH24:MI') AS WORK_TIME,
            TO_CHAR(QUIT_TIME, 'HH24:MI') AS QUIT_TIME,
            EXTRACT(HOUR FROM (QUIT_TIME - WORK_TIME)) AS TOTAL_HOURS,
            EXTRACT(MINUTE FROM (QUIT_TIME - WORK_TIME)) AS TOTAL_MINUTES
        FROM (
            SELECT
                NO,
                EMP_NO,
                WORK_TIME,
                QUIT_TIME
            FROM COMMUTE
            WHERE EMP_NO = #{empNo}
            ORDER BY WORK_TIME DESC
        )
        WHERE ROWNUM = 1
        """)
    CommuteVo workTimeByNo(String empNo);

}
