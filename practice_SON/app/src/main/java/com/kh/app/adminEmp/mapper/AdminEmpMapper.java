package com.kh.app.adminEmp.mapper;

import com.kh.app.adminEmp.vo.AdminEmpVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminEmpMapper {

    @Select("SELECT * FROM EMPLOYEE")
    List<AdminEmpVo> adminEmpList();
}
