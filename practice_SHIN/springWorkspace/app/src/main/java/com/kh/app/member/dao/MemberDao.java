package com.kh.app.member.dao;

import com.kh.app.member.mapper.MemberMapper;
import com.kh.app.member.member.vo.MemberVo;
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


    public MemberVo loin(MemberVo vo) {
        return mapper.login(vo);
    }
}//class
