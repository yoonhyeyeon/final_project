package com.kh.app.adminHr.mapper;

import com.kh.app.adminHr.vo.AdminHrVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminHrMapper {

    @Select("""
            SELECT *
            FROM HR_ACCOUNT
            WHERE ID = #{id} AND PWD = #{pwd}
            """)
    AdminHrVo login(AdminHrVo vo);
}
