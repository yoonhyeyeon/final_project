package com.kh.app.personal.dao;

import com.kh.app.personal.mapper.PersonalMapper;
import com.kh.app.personal.vo.PersonalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonalDao {

    private final PersonalMapper mapper;

    @Transactional
    public int write(PersonalVo vo) {
        return mapper.write(vo);
    }

    public List<PersonalVo> getPersonalList() {
        return mapper.getPersonalList();
    }
}
