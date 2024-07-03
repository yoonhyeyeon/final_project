package com.kh.app.personal.controller;

import com.kh.app.personal.serviec.PersonalService;
import com.kh.app.personal.vo.PersonalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("api/personal")
@RequiredArgsConstructor
public class PersonalApiController {

    private final PersonalService service;

    //목록조회
    @GetMapping("list")
    public List<PersonalVo> getPersonalList(){
        List<PersonalVo> voList = service.getPersonalList();
        return voList;
    }

    //작성하기
    @PostMapping  // POST 방식으로 요청을 처리하는 메소드
    public String getPersonalWrite(PersonalVo vo){
        int result = service.getPersonalWrite(vo);
        return result == 1 ? "personal/list" : "personal/write_fail";
    }

    //수정하기
//    @PostMapping("edit")
//    public String personalEdit(@RequestBody PersonalVo vo){
//        System.out.println("vo = " + vo);
//        int result = service.personalEdit(vo);
//        return result == 1 ? "edit success ~ !" : "edit fail...";
//    }
    @PostMapping("edit")
    public String personalEdit(@RequestBody PersonalVo vo) {
        System.out.println("vo = " + vo);
        int result = service.personalEdit(vo);
        return result == 1 ? "edit success ~ !" : "edit fail...";
    }


}
