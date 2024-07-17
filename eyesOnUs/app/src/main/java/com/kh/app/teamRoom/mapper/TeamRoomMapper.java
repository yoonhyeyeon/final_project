package com.kh.app.teamRoom.mapper;

import com.kh.app.teamRoom.vo.TeamRoomVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamRoomMapper {

    //진행 상태 && 최신작성 순
    @Select("SELECT * FROM PERSONAL_WORK WHERE STATE_B_NO = 1 ORDER BY NO ASC")
    public List<TeamRoomVo> getTodoList();

    @Select("SELECT * FROM PROJECT_WORK WHERE STATE_B_NO = 1 ORDER BY NO ASC")
    List<TeamRoomVo> getTodoPrjList();

    @Select("SELECT name, phone\n" +
            "FROM EMPLOYEE EMP\n" +
            "WHERE EMP.DEPT_CODE = (\n" +
            "    SELECT DEPT_CODE\n" +
            "    FROM EMPLOYEE\n" +
            "    WHERE NO = #{empNo}\n" +
            ") AND EMP.NO != #{empNo}")
    List<TeamRoomVo> list(String no);
    

}//class

