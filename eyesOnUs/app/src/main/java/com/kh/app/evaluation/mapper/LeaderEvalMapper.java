package com.kh.app.evaluation.mapper;

import com.kh.app.evaluation.vo.LeaderEvalVo;
import com.kh.app.sign.vo.EmployeeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LeaderEvalMapper {

    // 작성하기
    @Insert("INSERT INTO LEADER_EVAL (\n" +
            "    NO\n" +
            "    , EVALUATOR_NO\n" +
            "    , EVALUATEE_NO\n" +
            "    , COMMUNICATION\n" +
            "    , RESPONSIBILITY\n" +
            "    , JUDGEMENT\n" +
            "    , PROFESSIONALISM\n" +
            "    , START_DATE\n" +
            "    , END_DATE\n" +
            "    , COMPLIMENT\n" +
            "    , DISAPPOINTMENT\n" +
            "    , SUGGESTION\n" +
            ")\n" +
            "VALUES (\n" +
            "    SEQ_LEADER_EVAL.NEXTVAL\n" +
            "    , #{evaluatorNo}\n" +
            "    , #{evaluateeNo}\n" +
            "    , #{communication}\n" +
            "    , #{responsibility}\n" +
            "    , #{judgement}\n" +
            "    , #{professionalism}\n" +
            "    , '2024-07-06 09:00'\n" +
            "    , '2024-07-30 18:00'\n" +
            "    , #{compliment}\n" +
            "    , #{disappointment}\n" +
            "    , #{suggestion}\n" +
            ")")
    int write(LeaderEvalVo vo);

    @Select("SELECT NO FROM EMPLOYEE")
    List<EmployeeVo> writeList(EmployeeVo vo);

    // 목록조회
    @Select("SELECT \n" +
            "    L.NO\n" +
            "    , E.NAME AS EVALUATOR_NO\n" +
            "    , M.NAME AS EVALUATEE_NO\n" +
            "    , L.COMMUNICATION\n" +
            "    , L.RESPONSIBILITY\n" +
            "    , L.JUDGEMENT\n" +
            "    , L.PROFESSIONALISM\n" +
            "    , L.COMPLIMENT\n" +
            "    , L.DISAPPOINTMENT\n" +
            "    , L.SUGGESTION\n" +
            "    , TO_CHAR(L.WRITE_DATE, 'YYYY-MM-DD') AS WRITE_DATE\n" +
            "FROM LEADER_EVAL L\n" +
            "JOIN EMPLOYEE E\n" +
            "ON L.EVALUATOR_NO = E.NO\n" +
            "JOIN EMPLOYEE M\n" +
            "ON L.EVALUATEE_NO = M.NO\n" +
            "WHERE E.NO = #{no}\n" +
            "ORDER BY L.NO ASC")
    List<LeaderEvalVo> list(String no);

    @Select("SELECT * FROM EMPLOYEE")
    List<EmployeeVo> listByNo(EmployeeVo vo);

}
