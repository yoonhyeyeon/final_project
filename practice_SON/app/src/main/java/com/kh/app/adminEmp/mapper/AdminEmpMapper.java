package com.kh.app.adminEmp.mapper;

import com.kh.app.adminEmp.vo.AdminEmpVo;
import com.kh.app.adminEmp.vo.DivisionVo;
import com.kh.app.adminEmp.vo.PositionVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface AdminEmpMapper {

//    @Select("SELECT * FROM EMPLOYEE")
    @Select("SELECT E.NO, D.NAME AS DEPT_NAME, DIV.NAME AS DIV_NAME, P.NAME AS POSITION_NAME, E.NAME " +
            "FROM EMPLOYEE E " +
            "JOIN DEPARTMENT D ON E.DEPT_CODE = D.CODE " +
            "JOIN DIVISION DIV ON E.DIV_CODE = DIV.CODE " +
            "JOIN POSITION P ON E.POSITION_CODE = P.CODE " +
            "ORDER BY E.NO " +
            "OFFSET #{offset} ROWS FETCH NEXT #{limit} ROWS ONLY")
    List<AdminEmpVo> adminEmpList(@Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT E.NO, D.NAME AS DEPT_NAME, DIV.NAME AS DIV_NAME, P.NAME AS POSITION_NAME, E.NAME " +
            "FROM EMPLOYEE E " +
            "JOIN DEPARTMENT D ON E.DEPT_CODE = D.CODE " +
            "JOIN DIVISION DIV ON E.DIV_CODE = DIV.CODE " +
            "JOIN POSITION P ON E.POSITION_CODE = P.CODE " +
            "ORDER BY E.NO " +
            "OFFSET #{offset} ROWS FETCH NEXT #{limit} ROWS ONLY")
    List<AdminEmpVo> adminEmpListData(@Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM EMPLOYEE")
    int getTotalCount();

    @Select({
            "<script>",
            "SELECT COUNT(*)",
            "FROM EMPLOYEE E ",
            "JOIN DEPARTMENT D ON E.DEPT_CODE = D.CODE ",
            "JOIN DIVISION DIV ON E.DIV_CODE = DIV.CODE ",
            "JOIN POSITION P ON E.POSITION_CODE = P.CODE ",
            "WHERE ",
            "<choose>",
            "<when test='empCategory == \"deptName\"'>",
            "D.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"divName\"'>",
            "DIV.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"positionName\"'>",
            "P.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"name\"'>",
            "E.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "</choose>",
            "</script>"
    })
    int getSearchTotalCount(@Param("empCategory") String empCategory, @Param("searchBox") String searchBox);

    @Select("SELECT E.NO, D.NAME AS DEPT_NAME, DIV.NAME AS DIV_NAME, P.NAME AS POSITION_NAME, E.NAME, " +
            "E.DEPT_CODE, E.POSITION_CODE, E.STATE, E.SALARY_CODE, E.RANK, " +
            "E.SALARY, E.BONUS, E.ID, E.NICK, E.PHONE, E.ADDRESS, " +
            "E.ENROLL_DATE, E.RETIRE_DATE, E.RETIRE_YN " +
            "FROM EMPLOYEE E " +
            "JOIN DEPARTMENT D ON E.DEPT_CODE = D.CODE " +
            "JOIN DIVISION DIV ON E.DIV_CODE = DIV.CODE " +
            "JOIN POSITION P ON E.POSITION_CODE = P.CODE WHERE E.NO = #{no}")
    AdminEmpVo adminEmpByNo(@Param("no") String no);

    @Select({
            "<script>",
            "SELECT E.NO, D.NAME AS DEPT_NAME, DIV.NAME AS DIV_NAME, P.NAME AS POSITION_NAME, E.NAME ",
            "FROM EMPLOYEE E ",
            "JOIN DEPARTMENT D ON E.DEPT_CODE = D.CODE ",
            "JOIN DIVISION DIV ON E.DIV_CODE = DIV.CODE ",
            "JOIN POSITION P ON E.POSITION_CODE = P.CODE ",
            "WHERE ",
            "<choose>",
            "<when test='empCategory == \"deptName\"'>",
            "D.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"divName\"'>",
            "DIV.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"positionName\"'>",
            "P.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"name\"'>",
            "E.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "</choose>",
            "ORDER BY E.NO ",
            "OFFSET #{offset} ROWS FETCH NEXT #{limit} ROWS ONLY",
            "</script>"
    })
    List<AdminEmpVo> adminEmpSearch(@Param("empCategory") String empCategory, @Param("searchBox") String searchBox,
                                    @Param("offset") int offset, @Param("limit") int limit);

    @Select({
            "<script>",
            "SELECT E.NO, D.NAME AS DEPT_NAME, DIV.NAME AS DIV_NAME, P.NAME AS POSITION_NAME, E.NAME ",
            "FROM EMPLOYEE E ",
            "JOIN DEPARTMENT D ON E.DEPT_CODE = D.CODE ",
            "JOIN DIVISION DIV ON E.DIV_CODE = DIV.CODE ",
            "JOIN POSITION P ON E.POSITION_CODE = P.CODE ",
            "WHERE ",
            "<choose>",
            "<when test='empCategory == \"deptName\"'>",
            "D.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"divName\"'>",
            "DIV.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"positionName\"'>",
            "P.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"name\"'>",
            "E.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "</choose>",
            "ORDER BY E.NO ",
            "OFFSET #{offset} ROWS FETCH NEXT #{limit} ROWS ONLY",
            "</script>"
    })
    List<AdminEmpVo> adminEmpSearchData(@Param("empCategory") String empCategory, @Param("searchBox") String searchBox,
                                        @Param("offset") int offset, @Param("limit") int limit);


    @Insert("INSERT INTO EMPLOYEE (NO, ID, NICK, PWD, NAME, PHONE, ADDRESS, DEPT_CODE, DIV_CODE, POSITION_CODE, ENROLL_DATE) " +
            "VALUES (SEQ_EMPLOYEE.NEXTVAL, #{id}, #{nick}, #{pwd}, #{name}, #{phone}, #{address}, #{deptCode}, #{divCode}, #{positionCode}, #{enrollDate})")
    void adminEmpEnrollData(AdminEmpVo vo);

    @Select("SELECT E.NO, D.NAME AS DEPT_NAME, DIV.NAME AS DIV_NAME, P.NAME AS POSITION_NAME, E.NAME, " +
            "E.DEPT_CODE, E.POSITION_CODE, E.STATE, E.SALARY_CODE, E.RANK, " +
            "E.SALARY, E.BONUS, E.ID, E.NICK, E.PHONE, E.ADDRESS, " +
            "E.ENROLL_DATE, E.RETIRE_DATE, E.RETIRE_YN " +
            "FROM EMPLOYEE E " +
            "JOIN DEPARTMENT D ON E.DEPT_CODE = D.CODE " +
            "JOIN DIVISION DIV ON E.DIV_CODE = DIV.CODE " +
            "JOIN POSITION P ON E.POSITION_CODE = P.CODE WHERE E.NO = #{no}")
    Map<String, Object> adminEmpByNoData(AdminEmpVo vo);

    @Select("SELECT * FROM DIVISION WHERE DEPT_CODE = #{no}")
    List<DivisionVo> getDivCode(String no);

    @Insert("INSERT INTO EMPLOYEE (NO, ID, NICK, PWD, NAME, PHONE, ADDRESS, DEPT_CODE, DIV_CODE, POSITION_CODE, ENROLL_DATE) " +
            "VALUES (SEQ_EMPLOYEE.NEXTVAL, #{id}, #{nick}, #{pwd}, #{name}, #{phone}, #{address}, #{deptCode}, #{divCode}, #{positionCode}, #{enrollDate})")
    AdminEmpVo adminEmpEditData(String no);

    @Select("SELECT * FROM EMPLOYEE WHERE NO = #{no}")
    AdminEmpVo selectEmployeeByNo(@Param("no") String empNo);

    @Update("UPDATE EMPLOYEE " +
            "SET ID = #{id}, " +
            "NICK = #{nick}, " +
            "NAME = #{name}, " +
            "PHONE = #{phone}, " +
            "ADDRESS = #{address}, " +
            "ENROLL_DATE = #{enrollDate}, " +
            "DEPT_CODE = #{deptCode}, " +
            "DIV_CODE = #{divCode}, " +
            "POSITION_CODE = #{positionCode} " +
            "WHERE NO = #{no}")
    int updateEmployee(AdminEmpVo vo);
}
