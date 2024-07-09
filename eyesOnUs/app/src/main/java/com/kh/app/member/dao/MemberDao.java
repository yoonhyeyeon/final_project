package com.kh.app.member.dao;

import com.kh.app.member.mapper.MemberMapper;
import com.kh.app.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    private final MemberMapper mapper;

    public int join(MemberVo vo)
    {
        return mapper.join(vo);
    }

    // 로그인 (임시)
    public MemberVo login(MemberVo vo) {
        MemberVo loginMemberVo = mapper.login(vo);
        return loginMemberVo;
    }
}//class
