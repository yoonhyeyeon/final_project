package com.kh.app.home.service;

import com.kh.app.home.dao.HomeDao;
import com.kh.app.home.vo.HomeVo;
import com.kh.app.sign.vo.EmployeeVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HomeService {

    private final HomeDao dao;

    public List<EmployeeVo> list(EmployeeVo vo) {
        return dao.list(vo);
    }

    // 출근 시간
    public int write(HomeVo vo) {
        return dao.write(vo);
    }

    // 퇴근시간
    public int quit(HomeVo vo) {
        return dao.quit(vo);
    }


}
