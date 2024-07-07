package com.kh.app.teamRoom.mapper;

import com.kh.app.teamRoom.vo.TeamRoomVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TeamRoomMapper {

    @Select("SELECT * FROM PERSONAL_WORK ORDER BY NO DESC")
    public List<TeamRoomVo> getTodoList();


}//class

