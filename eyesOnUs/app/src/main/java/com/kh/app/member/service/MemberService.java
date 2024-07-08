package com.kh.app.member.service;

import com.kh.app.member.dao.MemberDao;
import com.kh.app.member.vo.MemberVo;
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

    // 로그인 (임시)
    public MemberVo login(MemberVo vo) {
        return dao.login(vo);
    }
}//class
