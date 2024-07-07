package com.kh.app.projectwork.controller;


import com.kh.app.personal.serviec.PersonalService;
import com.kh.app.personal.vo.PersonalVo;
import com.kh.app.projectwork.service.ProjectWorkService;
import com.kh.app.projectwork.vo.ProjectWorkVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/projectWork")
@RequiredArgsConstructor
public class ProjectWorkApiController {

    private final ProjectWorkService service;

    //목록조회
    @GetMapping("list")
    public List<ProjectWorkVo> getPrjWorkList(){
        List<ProjectWorkVo> voList = service.getPrjWorkList();
        return voList;
    }

    //작성하기
    @PostMapping("write")
    public ResponseEntity<String> getPrjWorkWrite(ProjectWorkVo vo) {
        int result = service.getPrjWorkWrite(vo);
        if(result == 1){
            return ResponseEntity.ok("작성하기 성공");
        }else {
            return ResponseEntity.internalServerError().body("작성하기 실패");
        }
    }

}//class
