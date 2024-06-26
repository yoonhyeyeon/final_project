package com.kh.app.personal.service;

import com.kh.app.personal.dao.PersonalDao;
import com.kh.app.personal.vo.PersonalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonalService {

    private final PersonalDao dao;

    public int write(PersonalVo vo) {
        return dao.write(vo);
    }


    public void savePersonal(PersonalVo vo) {
        dao.save(vo);
    }
}
