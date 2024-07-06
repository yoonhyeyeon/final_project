package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.LeaderEvalMapper;
import com.kh.app.evaluation.vo.LeaderEvalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LeaderEvalDao {

    private final LeaderEvalMapper mapper;

    // 작성하기
    public int write(LeaderEvalVo vo) {
        return mapper.write(vo);
    }

}
