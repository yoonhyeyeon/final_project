package com.kh.app.teamRoom.dao;

import com.kh.app.teamRoom.mapper.TeamRoomMapper;
import com.kh.app.teamRoom.vo.TeamRoomVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamRoomDao {

    private final TeamRoomMapper mapper;

    public List<TeamRoomVo> getTodoList() {
        return mapper.getTodoList();
    }
}//class
