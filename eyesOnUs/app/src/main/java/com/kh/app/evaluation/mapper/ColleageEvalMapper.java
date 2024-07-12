package com.kh.app.evaluation.mapper;

import com.kh.app.evaluation.vo.ColleageEvalVo;
import com.kh.app.sign.vo.EmployeeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ColleageEvalMapper {

    // 작성하기
    @Insert("INSERT INTO COLLEAGE_EVAL (\n" +
            "    NO\n" +
            "    , EVALUATOR_NO\n" +
            "    , EVALUATEE_NO\n" +
            "    , POTENTIAL\n" +
            "    , COMMUNICATION\n" +
            "    , PROBLEM_SOLVE\n" +
            "    , RESPONSIBILITY\n" +
            "    , START_DATE\n" +
            "    , END_DATE\n" +
            "    , COMPLIMENT\n" +
            "    , DISAPPOINTMENT\n" +
            "    , SUGGESTION\n" +
            ")\n" +
            "VALUES (\n" +
            "    SEQ_COLLEAGE_EVAL.NEXTVAL\n" +
            "    , #{evaluatorNo}\n" +
            "    , #{evaluateeNo}\n" +
            "    , #{potential}\n" +
            "    , #{communication}\n" +
            "    , #{problemSolve}\n" +
            "    , #{responsibility}\n" +
            "    , '2024-07-06 09:00'\n" +
            "    , '2024-07-30 18:00'\n" +
            "    , #{compliment}\n" +
            "    , #{disappointment}\n" +
            "    , #{suggestion}\n" +
            ")")
    int write(ColleageEvalVo vo);

    @Select("SELECT * FROM EMPLOYEE")
    List<EmployeeVo> writeList(EmployeeVo vo);

    // 목록조회
    @Select("""
            SELECT
                C.NO
                , E.NAME AS EVALUATOR_NO
                , M.NAME AS EVALUATEE_NO
                , C.POTENTIAL
                , C.COMMUNICATION
                , C.PROBLEM_SOLVE
                , C.RESPONSIBILITY
                , C.COMPLIMENT
                , C.DISAPPOINTMENT
                , C.SUGGESTION
                , TO_CHAR(C.WRITE_DATE, 'YYYY-MM-DD') AS WRITE_DATE
            FROM COLLEAGE_EVAL C
            JOIN EMPLOYEE E
            ON C.EVALUATOR_NO = E.NO
            JOIN EMPLOYEE M
            ON C.EVALUATEE_NO = M.NO
            WHERE E.NO = #{no}
            ORDER BY C.NO ASC
            """)
    List<ColleageEvalVo> list(String no);

    @Select("SELECT * FROM EMPLOYEE")
    List<EmployeeVo> listByNo(EmployeeVo vo);
}
