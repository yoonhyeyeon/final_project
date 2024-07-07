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
            "    , TO_TIMESTAMP('2024-07-08 09:00', 'YYYY-MM-DD HH24:MI')\n" +
            "    , TO_TIMESTAMP('2024-07-14 18:00', 'YYYY-MM-DD HH24:MI')\n" +
            "    , #{compliment}\n" +
            "    , #{disappointment}\n" +
            "    , #{suggestion}\n" +
            ")")
    int write(ColleageEvalVo vo);

    @Select("SELECT NAME FROM EMPLOYEE")
    List<EmployeeVo> writeList(EmployeeVo vo);

    // 목록조회
    @Select("SELECT \n" +
            "    C.NO\n" +
            "    , E.NAME AS EVALUATOR_NO\n" +
            "    , M.NAME AS EVALUATEE_NO\n" +
            "    , C.POTENTIAL\n" +
            "    , C.COMMUNICATION\n" +
            "    , C.PROBLEM_SOLVE\n" +
            "    , C.RESPONSIBILITY\n" +
            "    , C.COMPLIMENT\n" +
            "    , C.DISAPPOINTMENT\n" +
            "    , C.SUGGESTION\n" +
            "    , TO_CHAR(C.WRITE_DATE, 'YYYY-MM-DD') AS WRITE_DATE\n" +
            "FROM COLLEAGE_EVAL C\n" +
            "JOIN EMPLOYEE E\n" +
            "ON C.EVALUATOR_NO = E.NO\n" +
            "JOIN EMPLOYEE M\n" +
            "ON C.EVALUATEE_NO = M.NO\n" +
            "ORDER BY C.NO ASC")
    List<ColleageEvalVo> list();

}
