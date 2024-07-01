package com.kh.app99.board.controller;

import com.kh.app99.board.service.BoardService;
import com.kh.app99.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("api/board")
@RequiredArgsConstructor
public class BoardRestController {

    private final BoardService service;

    //게시글 작성
    @PostMapping
    @ResponseBody
    public HashMap<String, String> write(BoardVo vo){
        int result = service.write(vo);
        if(result != 1){
           throw new RuntimeException();
        }

        HashMap<String, String> map = new HashMap<>();
        map.put("msg" , "write.jsp success ~ !");
        map.put("status", "200 OK");

        return map;
    }

    //게시글 상세조회 (번호)
    @GetMapping
    public ResponseEntity getBoardByNo(String num){
        BoardVo vo = service.getBoardByNo(num);

        if(vo == null){
            throw new RuntimeException();
        }

        return ResponseEntity
                .ok(vo);
    }

    //게시글 삭제 (번호)
    @DeleteMapping
    public ResponseEntity<String> deleteBoardByNo(String num){
        int result = service.deleteBoardByNo(num);

        if(result != 1){
            throw new RuntimeException();
        }

        return ResponseEntity.ok("delete success!!!");
    }

}//class
