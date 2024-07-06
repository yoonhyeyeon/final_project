package com.kh.app.evaluation.mapper;

import com.kh.app.evaluation.vo.MemberEvalVo;
import com.kh.app.sign.vo.EmployeeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberEvalMapper {

    // 작성하기
    @Insert("INSERT INTO MEMBER_EVAL (\n" +
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
            ")VALUES (\n" +
            "    SEQ_MEMBER_EVAL.NEXTVAL\n" +
            "    , #{evaluatorNo}\n" +
            "    , #{evaluateeNo}\n" +
            "    , #{potential}\n" +
            "    , #{communication}\n" +
            "    , #{problemSolve}\n" +
            "    , #{responsibility}\n" +
            "    , '2024-07-02 09:00'\n" +
            "    , '2024-07-30 18:00'\n" +
            "    , #{compliment}\n" +
            "    , #{disappointment}\n" +
            "    , #{suggestion}\n" +
            ")")
    int write(MemberEvalVo vo);

    @Select("SELECT\n" +
            "    NAME\n" +
            "FROM EMPLOYEE")
    List<EmployeeVo> writeList(EmployeeVo vo);

    // 목록조회
    @Select("SELECT \n" +
            "    M.NO\n" +
            "    , E.NAME AS EVALUATOR_NO\n" +
            "    , P.NAME AS EVALUATEE_NO\n" +
            "    , M.POTENTIAL\n" +
            "    , M.COMMUNICATION\n" +
            "    , M.PROBLEM_SOLVE\n" +
            "    , M.RESPONSIBILITY\n" +
            "    , M.COMPLIMENT\n" +
            "    , M.DISAPPOINTMENT\n" +
            "    , M.SUGGESTION\n" +
            "    , TO_CHAR(M.WRITE_DATE, 'YYYY-MM-DD') AS WRITE_DATE\n" +
            "FROM MEMBER_EVAL M\n" +
            "JOIN EMPLOYEE E\n" +
            "ON M.EVALUATOR_NO = E.NO\n" +
            "JOIN EMPLOYEE P\n" +
            "ON M.EVALUATEE_NO = P.NO\n" +
            "ORDER BY M.NO ASC")
    List<MemberEvalVo> list();

}
