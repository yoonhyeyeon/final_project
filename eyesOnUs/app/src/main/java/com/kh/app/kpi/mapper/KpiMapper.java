package com.kh.app.kpi.mapper;

import com.kh.app.kpi.vo.KpiVo;
import com.kh.app.project.vo.ProjectVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface KpiMapper {

    // 게시글 작성
    @Insert("INSERT INTO KPI (NO, EMP_NO, PROJECT_NO, GOAL, PERSONAL_SCHEDULE, FOCUS) VALUES (SEQ_KPI.NEXTVAL, #{empNo}, #{projectNo}, #{goal}, #{personalSchedule}, #{focus})")
    int kpiWrite(KpiVo vo);

    // vo 값 가져오기
    @Select("SELECT * FROM PROJECT")
    List<ProjectVo> writeList(ProjectVo vo);

    // 게시글 목록
    @Select("""
            SELECT
                K.NO
                , K.PROJECT_NO
                , P.TITLE
                , K.FOCUS
                , P.START_DATE
            FROM KPI K
            JOIN PROJECT P
            ON K.PROJECT_NO = P.NO
            WHERE K.EMP_NO = #{empNo}
            ORDER BY K.NO ASC
            """)
    List<KpiVo> KpiList(String empNo);

    // 게시글 상세조회
    @Select("SELECT K.NO , K.PROJECT_NO , P.TITLE , K.GOAL , K.PERSONAL_SCHEDULE , K.FOCUS , P.START_DATE , K.ENROLL_DATE FROM KPI K JOIN PROJECT P ON K.PROJECT_NO = P.NO WHERE K.NO = #{no}")
    KpiVo kpiByNo(String no);

    // 게시글 수정
    @Update("UPDATE KPI SET PROJECT_NO = #{projectNo} ,GOAL =#{goal} , PERSONAL_SCHEDULE = #{personalSchedule} WHERE NO = #{no}")
    int kpiModify(KpiVo vo);


    // 게시글 삭제
    @Delete("DELETE FROM KPI WHERE NO = #{no}")
    int kpiDelete(String no);

}
