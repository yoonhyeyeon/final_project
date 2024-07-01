package com.kh.app99.member.service;

import com.kh.app99.member.dao.MemberDao;
import com.kh.app99.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberDao dao;

    public int join(MemberVo vo) {
        if(vo.getId().length() < 4){
            throw new RuntimeException();
        }

        return dao.join(vo);
    }//method

    public MemberVo login(MemberVo vo) {
        return dao.login(vo);
    }

    public int quit(String num) {
        return dao.quit(num);
    }
}//class
