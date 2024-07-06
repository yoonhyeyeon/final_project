package com.kh.app.personal.personal.dao;

import com.kh.app.personal.mapper.PersonalMapper;
import com.kh.app.personal.vo.PersonalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonalDao {

    private final PersonalMapper mapper;


    public List<PersonalVo> getPersonalList() {
        return mapper.getPersonalList();
    }



    public int getPersonalWrite(PersonalVo vo) {
        return mapper.getPersonalWrite(vo);
    }

    public int personalEdit(PersonalVo vo) {
        return mapper.personalEdit(vo);
    }
}