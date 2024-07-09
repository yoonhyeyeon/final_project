package com.kh.app.personal.controller;

import com.kh.app.personal.serviec.PersonalService;
import com.kh.app.personal.vo.PersonalVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

//    //작성하기
    @PostMapping("write")
    public RedirectView getPersonalWrite(PersonalVo vo) {
        System.out.println("vo = " + vo);
        int result = service.getPersonalWrite(vo);
        if(result == 1){
            // 작성 성공 시 리다이렉트
            return new RedirectView("/personal");
        }else {
            // 작성 실패 시 에러 페이지로 리다이렉트
            return new RedirectView("/personal");
        }
    }

    @DeleteMapping("delete/{num}")
    public ResponseEntity<String> personalDelete(@PathVariable String num){
        int result = service.personalDelete(num);
        System.out.println("result = " + result);
        if (result == 1) {
            return ResponseEntity.ok("delete success ~ !");
        } else {
            return ResponseEntity.status(500).body("delete fail...");
        }
    }


}
