package com.kh.app.home.service;

import com.kh.app.home.dao.CommuteDao;
import com.kh.app.home.vo.CommuteVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommuteService {

    private final CommuteDao dao;

    // 출근 시간
    public int write(CommuteVo vo) {
        return dao.write(vo);
    }

    // 퇴근시간
    public int quit(CommuteVo vo) {
        return dao.quit(vo);
    }
}
