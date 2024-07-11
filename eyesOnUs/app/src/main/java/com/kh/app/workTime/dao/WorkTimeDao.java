package com.kh.app.workTime.dao;

import com.kh.app.home.vo.CommuteVo;
import com.kh.app.workTime.mapper.WorkTimeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WorkTimeDao {

    private final WorkTimeMapper mapper;

    public CommuteVo workTimeByNo(String empNo) {
        return mapper.workTimeByNo(empNo);
    }

}