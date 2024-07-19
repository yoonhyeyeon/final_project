package com.kh.app.member.mapper;

import com.kh.app.member.vo.MemberVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

    //회원가입 기능
    @Insert("INSERT INTO EMPLOYEE\n" +
            "(\n" +
            "    NO,\n" +
            "    POSITION_CODE,\n" +
            "    ID,\n" +
            "    PWD,\n" +
            "    NICK,\n" +
            "    NAME,\n" +
            "    PHONE,\n" +
            "    ADDRESS,\n" +
            "    PROFILE,\n" +
            "    ENROLL_DATE\n" +
            ") VALUES (\n" +
            "    SEQ_EMPLOYEE.NEXTVAL,\n" +
            "    #{positionCode},\n" +
            "    #{id},\n" +
            "    #{pwd},\n" +
            "    #{nick},\n" +
            "    #{name},\n" +
            "    #{phone},\n" +
            "    #{address},\n" +
            "    #{profile},\n" +
            "    SYSDATE\n" +
            ")\n")
    public int join(MemberVo vo);

    // 로그인 (임시)
//    @Select({"""
//            SELECT *
//            FROM EMPLOYEE
//            WHERE ID = #{id}
//            AND PWD = #{pwd}
//            """})
//    MemberVo login(MemberVo vo);
    @Select("""
            SELECT
                E.NO,
                E.DEPT_CODE,
                E.DIV_CODE,
                E.POSITION_CODE,
                E.STATE,
                E.SALARY_CODE,
                E.RANK,
                E.SALARY,
                E.ID,
                E.PWD,
                E.NICK,
                E.NAME,
                E.PHONE,
                E.ADDRESS,
                E.PROFILE,
                E.ENROLL_DATE,
                E.RETIRE_DATE,
                E.RETIRE_YN,
                D.NAME AS DEPT_NAME,
                V.NAME AS DIV_NAME,
                P.NAME AS POSITION_NAME
            FROM EMPLOYEE E
            JOIN DEPARTMENT D ON D.CODE = E.DEPT_CODE
            JOIN DIVISION V ON E.DIV_CODE = V.CODE
            JOIN POSITION P ON E.POSITION_CODE = P.CODE
            WHERE E.ID = #{id}
            AND E.PWD = #{pwd}
            """)
    MemberVo login(MemberVo vo);

}//class
