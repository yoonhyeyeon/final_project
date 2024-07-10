package com.kh.app.test.mapper;

import com.kh.app.test.vo.TestTeamCalendarVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("""
    SELECT *
    FROM PROJECT_WORK
    ORDER BY NO DESC
    """)
    List<TestTeamCalendarVo> teamCalendarData();

}
