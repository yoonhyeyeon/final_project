package com.kh.app.member.mapper;

import com.kh.app.member.member.vo.MemberVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

    //회원가입 기능
    @Insert("INSERT INTO EMPLOYEE\n" +
            "(\n" +
            "    NO\n" +
            "    ,ID\n" +
            "    ,PWD\n" +
            "    ,NICK\n" +
            "    ,NAME\n" +
            "    ,PHONE\n" +
            "    ,ADDRESS\n" +
            "    ,PROFILE\n" +
            "    ,ENROLL_DATE\n" +
            ")VALUES(\n" +
            "    SEQ_EMPLOYEE.NEXTVAL\n" +
            "    , #{id}\n" +
            "    , #{pwd}\n" +
            "    , #{nick}\n" +
            "    , #{name}\n" +
            "    , #{phone}\n" +
            "    , #{address}\n" +
            "    , #{profile}\n" +
            "    ,SYSDATE\n" +
            ")")
    public int join(MemberVo vo);

    @Select("SELECT * FROM EMPLOYEE WHERE ID = #{id} AND PWD = #{pwd}")
    MemberVo login(MemberVo vo);
}//class
