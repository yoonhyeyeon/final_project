package com.kh.app.adminDept.mapper;

import com.kh.app.adminDept.vo.DivisionVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminDeptMapper {

    @Select("SELECT D.CODE, D.DEPT_CODE, D.NAME, D.STATE, DEPT.NAME AS DEPT_NAME, " +
            "TO_CHAR(D.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, " +
            "TO_CHAR(D.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE " +
            "FROM DIVISION D " +
            "JOIN DEPARTMENT DEPT ON D.DEPT_CODE = DEPT.CODE " +
            "ORDER BY D.CODE " +
            "OFFSET #{offset} ROWS FETCH NEXT #{limit} ROWS ONLY")
    List<DivisionVo> adminDeptList(@Param("offset") int offset, @Param("limit") int limit);

    @Select({"<script>",
            "SELECT D.CODE, D.DEPT_CODE, D.NAME, D.STATE, " +
                    "TO_CHAR(D.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, " +
                    "TO_CHAR(D.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE, " +
                    "DEPT.NAME AS DEPT_NAME " +
                    "FROM DIVISION D " +
                    "JOIN DEPARTMENT DEPT ON D.DEPT_CODE = DEPT.CODE " +
                    "WHERE ",
            "<choose>",
            "<when test='empCategory == \"deptName\"'>",
            "DEPT.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"name\"'>",
            "D.NAME LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "<when test='empCategory == \"state\"'>",
            "D.STATE LIKE '%' || #{searchBox} || '%'",
            "</when>",
            "</choose>",
            "ORDER BY D.CODE " +
                    "OFFSET #{offset} ROWS FETCH NEXT #{limit} ROWS ONLY",
            "</script>"})
    List<DivisionVo> adminDeptSearch(@Param("empCategory") String empCategory, @Param("searchBox") String searchBox, @Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM DIVISION")
    int getTotalCount();

    @Insert("INSERT INTO DIVISION (CODE, DEPT_CODE, NAME, STATE, ENROLL_DATE, MODIFY_DATE, END_DATE) " +
            "VALUES (#{code}, #{deptCode}, #{name}, #{state}, #{enrollDate}, CURRENT_TIMESTAMP, NULL)")
    void enrollDiv(DivisionVo divisionVo);

    @Select("SELECT NAME FROM DEPARTMENT WHERE CODE = #{deptCode}")
    String getDeptName(@Param("deptCode") String deptCode);

    @Select({"<script>",
            "SELECT D.CODE, D.DEPT_CODE, D.NAME, D.STATE, DEPT.NAME AS DEPT_NAME, " +
                    "TO_CHAR(D.ENROLL_DATE, 'YYYY.MM.DD') AS ENROLL_DATE, " +
                    "TO_CHAR(D.MODIFY_DATE, 'YYYY.MM.DD') AS MODIFY_DATE " +
                    "FROM DIVISION D " +
                    "JOIN DEPARTMENT DEPT ON D.DEPT_CODE = DEPT.CODE " +
                    "WHERE D.CODE = #{deptCode}",
            "</script>"})
    DivisionVo getDivisionByCode(String deptCode);

    @Update("UPDATE DIVISION SET " +
            "DEPT_CODE = #{deptCode}, " +
            "NAME = #{name}, " +
            "STATE = #{state}, " +
            "ENROLL_DATE = #{enrollDate}, " +
            "MODIFY_DATE = #{modifyDate} " +
            "WHERE CODE = #{code}")
    void updateDivision(DivisionVo divisionVo);

}
