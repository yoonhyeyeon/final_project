package com.kh.app.projectwork.controller;


import com.kh.app.projectwork.service.ProjectWorkService;
import com.kh.app.projectwork.vo.ProjectWorkVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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


    @PostMapping("write")
    public RedirectView getPrjWorkWrite(ProjectWorkVo vo) {
        int result = service.getPrjWorkWrite(vo);
        if(result == 1){
            // 작성 성공 시 리다이렉트
            return new RedirectView("/projectWork");
        }else {
            // 작성 실패 시 에러 페이지로 리다이렉트
            return new RedirectView("/projectWork");
        }
    }


    @DeleteMapping("delete/{num}")
    public ResponseEntity<String> prjWorkDelete(@PathVariable String num){
        int result = service.prjWorkDelete(num);
        System.out.println("result = " + result);
        if (result == 1) {
            return ResponseEntity.ok("delete success ~ !");
        } else {
            return ResponseEntity.status(500).body("delete fail...");
        }
    }

}//class
