package com.kh.app99.member.mapper;

import com.kh.app99.member.service.MemberService;
import com.kh.app99.member.vo.MemberVo;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface MemberMapper {

    @Insert("INSERT INTO MEMBER\n" +
            "(\n" +
            "    NO\n" +
            "    , ID\n" +
            "    , PWD\n" +
            "    , NICK\n" +
            ") \n" +
            "VALUES\n" +
            "(\n" +
            "    SEQ_MEMBER.NEXTVAL\n" +
            "    , #{id}\n" +
            "    , #{pwd}\n" +
            "    , #{nick}\n" +
            ")")
    int join(MemberVo vo);

    @Select("SELECT * FROM MEMBER WHERE ID = #{id} AND PWD = #{pwd}")
    MemberVo login(MemberVo vo);

    @Update("UPDATE MEMBER SET DEL_YN = 'Y' WHERE NO = #{num}")
    int quit(String num);
}
