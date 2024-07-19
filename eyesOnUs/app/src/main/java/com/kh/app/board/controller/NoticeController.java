package com.kh.app.board.controller;

import com.kh.app.board.service.NoticeService;
import com.kh.app.board.vo.NoticeVo;
import com.kh.app.member.vo.MemberVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("notice")
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService service;

    // 작성하기
    @GetMapping("write")
    public String write(){
        return "board/notice/write";
    }

    @PostMapping("write")
    @ResponseBody
    public HashMap<String, String > write(NoticeVo vo, HttpSession session){
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");

        int result = service.write(vo);

        HashMap<String, String > map = new HashMap<>();
        if( loginMemberVo == null ){
            map.put("msg", "로그인 필요");
            return map;
        }

        map.put("msg", "작성 성공");
        if( result != 1){
            map.put("msg", "작성 실패");
        }
        return map;
    }

    // 목록
    @GetMapping("list")
    public String list(){
        return "board/notice/list";
    }

    @GetMapping("listData")
    @ResponseBody
    public List<NoticeVo> listData(HttpSession session){

        //MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        //String empNo = loginMemberVo.getNo();

        List<NoticeVo> voList = service.listData();

        return voList;
    }

    // 상세조회
    @GetMapping("detail")
    public String noticeByNo(){
        return "board/notice/detail";
    }

    @GetMapping("detailData")
    @ResponseBody
    public NoticeVo noticeByNoData(NoticeVo vo){
        return service.noticeByNo(vo.getNo());
    }

    // 수정하기
    @GetMapping("modify")
    public String modify(){
        return "board/notice/modify";
    }

    @PostMapping("modify")
    @ResponseBody
    public ResponseEntity<HashMap<String, String>> modify(NoticeVo vo){
        int result = service.modify(vo);

        HashMap<String, String> map = new HashMap<>();

        if( result == 1 ){
            map.put("msg", "작성성공");
            return ResponseEntity.ok(map);
        }else{
            map.put("msg", "작성실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }

    // 삭제하기
    @DeleteMapping("delete")
    @ResponseBody
    public ResponseEntity<HashMap<String, String>> delete(String no){
        int result = service.delete(no);

        HashMap<String, String> map = new HashMap<>();
        if( result == 1 ){
            map.put("msg", "삭제성공");
            return ResponseEntity.ok(map);
        } else{
            map.put("msg", "삭제 실패");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
        }
    }


//////////홈 공지사항 조회///////////////

    // 목록
    @GetMapping("homeList")
    public String homeList(){
        return "board/notice/homeList";
    }


}
