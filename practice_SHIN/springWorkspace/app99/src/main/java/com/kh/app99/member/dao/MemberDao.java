package com.kh.app99.member.dao;

import com.kh.app99.member.mapper.MemberMapper;
import com.kh.app99.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    private final MemberMapper mapper;

    public int join(MemberVo vo) {
        return mapper.join(vo);
    }

    public MemberVo login(MemberVo vo) {
        return mapper.login(vo);
    }

    public int quit(String num) {
        return mapper.quit(num);
    }
}
