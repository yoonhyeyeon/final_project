package com.kh.app.evaluation.mapper;

import com.kh.app.evaluation.vo.LeaderEvalVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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


}
