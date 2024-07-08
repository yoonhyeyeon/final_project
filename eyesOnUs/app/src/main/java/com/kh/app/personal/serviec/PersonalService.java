package com.kh.app.personal.serviec;

import com.kh.app.personal.personal.dao.PersonalDao;
import com.kh.app.personal.vo.PersonalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalService {

    private final PersonalDao dao;


    public List<PersonalVo> getPersonalList() {
        return dao.getPersonalList();
    }


    public int getPersonalWrite(PersonalVo vo) {
        return dao.getPersonalWrite(vo);
    }


    public int personalDelete(String num) {
        return dao.personalDelete(num);
    }
}//class
