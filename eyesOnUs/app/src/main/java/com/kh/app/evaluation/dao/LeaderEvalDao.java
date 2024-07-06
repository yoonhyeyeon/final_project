package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.LeaderEvalMapper;
import com.kh.app.evaluation.vo.LeaderEvalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LeaderEvalDao {

    private final LeaderEvalMapper mapper;

    // 작성하기
    public int write(LeaderEvalVo vo) {
        return mapper.write(vo);
    }

    // 목록조회
    public List<LeaderEvalVo> list() {
        return mapper.list();
    }
}
