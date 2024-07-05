package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.LeaderEvalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LeaderEvalDao {

    private final LeaderEvalMapper mapper;

}
