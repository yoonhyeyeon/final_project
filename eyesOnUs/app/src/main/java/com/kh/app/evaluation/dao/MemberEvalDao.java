package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.MemberEvalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberEvalDao {

    private final MemberEvalMapper mapper;

}
