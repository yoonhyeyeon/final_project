package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    private final MemberMapper mapper;

}
