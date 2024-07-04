package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.LeaderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LeaderDao {

    private final LeaderMapper mapper;

}
