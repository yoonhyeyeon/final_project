package com.kh.app.member.service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberDao dao;

    public int join(MemberVo vo) {
        return dao.join(vo);
    }

    public MemberVo login(MemberVo vo) {
        return dao.loin(vo);
    }


}//class
