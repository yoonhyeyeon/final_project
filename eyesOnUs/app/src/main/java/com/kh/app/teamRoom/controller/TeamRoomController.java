package com.kh.app.teamRoom.controller;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("teamRoom")
public class TeamRoomController {

    //팀룸 화면
    @GetMapping
    public String write(){
        return "teamRoom/teamRoom";
    }

}
