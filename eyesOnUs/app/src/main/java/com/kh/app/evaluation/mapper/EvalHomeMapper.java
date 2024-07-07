package com.kh.app.evaluation.mapper;

import com.kh.app.sign.vo.EmployeeVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EvalHomeMapper {

    @Select("SELECT \n" +
            "    NAME\n" +
            "FROM EMPLOYEE \n" +
            "WHERE DEPT_CODE = (\n" +
            "SELECT\n" +
            "    DEPT_CODE\n" +
            "FROM EMPLOYEE\n" +
            "WHERE NO = #{no}\n" +
            ")\n" +
            "AND POSITION_CODE = (\n" +
            "SELECT\n" +
            "    POSITION_CODE\n" +
            "FROM EMPLOYEE\n" +
            "WHERE NO = #{no}\n" +
            ")")
    List<EmployeeVo> list();

}
