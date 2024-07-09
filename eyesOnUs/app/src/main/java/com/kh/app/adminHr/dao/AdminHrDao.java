package com.kh.app.adminHr.dao;

import com.kh.app.adminHr.mapper.AdminHrMapper;
import com.kh.app.adminHr.vo.AdminHrVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdminHrDao {

    private final AdminHrMapper mapper;

    public AdminHrVo login(AdminHrVo vo) {
        return mapper.login(vo);
    }
}
