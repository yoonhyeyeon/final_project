package com.kh.app.evaluation.dao;

import com.kh.app.evaluation.mapper.ColleageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ColleageDao {

    private final ColleageMapper mapper;

}
