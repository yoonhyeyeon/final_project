package com.kh.app.adminHr.service;

import com.kh.app.adminHr.dao.AdminHrDao;
import com.kh.app.adminHr.vo.AdminHrVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.regex.Pattern.matches;

@Service
@RequiredArgsConstructor
public class AdminHrServeice {

    private final AdminHrDao dao;

    public AdminHrVo login(AdminHrVo vo) {
        return dao.login(vo);
    }
}
