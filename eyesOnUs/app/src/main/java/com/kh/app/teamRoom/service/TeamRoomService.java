package com.kh.app.teamRoom.service;

import com.kh.app.teamRoom.dao.TeamRoomDao;
import com.kh.app.teamRoom.vo.TeamRoomVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamRoomService {

    private final TeamRoomDao dao;

    public List<TeamRoomVo> getTodoList() {
        return dao.getTodoList();
    }

    public List<TeamRoomVo> getTodoPrjList() {
        return dao.getTodoPrjList();
    }
}
