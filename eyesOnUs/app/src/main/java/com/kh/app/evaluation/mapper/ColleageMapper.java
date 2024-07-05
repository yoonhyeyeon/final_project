package com.kh.app.evaluation.mapper;

import com.kh.app.evaluation.vo.ColleageVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ColleageMapper {

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
            "    , #{EVALUATORNO}\n" +
            "    , #{EVALUATEENO}\n" +
            "    , #{POTENTIAL}\n" +
            "    , #{COMMUNICATION}\n" +
            "    , #{PROBLEM_SOLVE}\n" +
            "    , #{RESPONSIBILITY}\n" +
            "    , TO_TIMESTAMP('2024-07-08 09:00', 'YYYY-MM-DD HH24:MI')\n" +
            "    , TO_TIMESTAMP('2024-07-14 18:00', 'YYYY-MM-DD HH24:MI')\n" +
            "    , #{COMPLIMENT}\n" +
            "    , #{DISAPPOINTMENT}\n" +
            "    , #{SUGGESTION}\n" +
            ")")
    int write(ColleageVo vo);


}
