package com.kh.app.adminEmp.mapper;

import com.kh.app.adminEmp.vo.AdminEmpVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminEmpMapper {

//    @Select("SELECT * FROM EMPLOYEE")
    @Select("SELECT E.NO, D.NAME AS DEPT_NAME, P.NAME AS POSITION_NAME, E.NAME " +
            "FROM EMPLOYEE E " +
            "JOIN DEPARTMENT D ON E.DEPT_CODE = D.CODE " +
            "JOIN POSITION P ON E.POSITION_CODE = P.CODE " +
            "ORDER BY E.NO " +
            "OFFSET #{offset} ROWS FETCH NEXT #{limit} ROWS ONLY")
    List<AdminEmpVo> adminEmpList(@Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM EMPLOYEE")
    int getTotalCount();

    @Select(("SELECT E.NO, D.NAME AS DEPT_NAME, P.NAME AS POSITION_NAME, E.NAME " +
            "E.DEPT_CODE, E.POSITION_CODE, E.STATE, E.SALARY_CODE, E.RANK " +
            "E.SALARY, E.BONUS, E.ID, E.NICK, E.PHONE, E.ADDRESS " +
            "E.ENROLL_DATE, E.RETIRE_DATE, E.RETIRE_YN " +
            "FROM EMPLOYEE E "+
            "JOIN DEPARTMENT D ON E.DEPT_CODE = D.CODE " +
            "JOIN POSITION P ON E.POSITION_CODE = P.CODE WHERE E.NO = #{no}"))
    AdminEmpVo adminEmpByNo(@Param("no") String no);
}
