package com.kh.app.home.mapper;

import com.kh.app.home.vo.HomeVo;
import com.kh.app.sign.vo.EmployeeVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface HomeMapper {

    @Select("""
            SELECT\s
                E.NO
                , E.DEPT_CODE
                , E.DIV_CODE
                , E.POSITION_CODE
                , E.STATE
                , E.SALARY_CODE
                , E.RANK
                , E.SALARY
                , E.ID
                , E.PWD
                , E.NICK
                , E.NAME
                , E.PHONE
                , E.ADDRESS
                , E.PROFILE
                , E.ENROLL_DATE
                , E.RETIRE_DATE
                , E.RETIRE_YN
                , D.NAME AS DEPT_NAME
                , V.NAME AS DIV_NAME
                , P.NAME AS POSITION_NAME
            FROM EMPLOYEE E
            JOIN DEPARTMENT D
            ON D.CODE = E.DEPT_CODE
            JOIN DIVISION V
            ON E.DIV_CODE = V.CODE
            JOIN POSITION P
            ON E.POSITION_CODE = P.CODE
            """)
    List<EmployeeVo> list(EmployeeVo vo);

    // 출근시간
    @Insert("INSERT INTO COMMUTE (NO, EMP_NO, WORK_TIME) VALUES (SEQ_COMMUTE.NEXTVAL, #{empNo}, SYSDATE)")
    int write(HomeVo vo);

    // 퇴근시간
    @Update("UPDATE COMMUTE\n" +
            "SET QUIT_TIME = SYSDATE\n" +
            "WHERE EMP_NO = #{empNo} AND WORK_TIME = (\n" +
            "    SELECT MAX(WORK_TIME) \n" +
            "    FROM COMMUTE \n" +
            "    WHERE EMP_NO = #{empNo}\n" +
            ")")
    int quit(HomeVo vo);

}
