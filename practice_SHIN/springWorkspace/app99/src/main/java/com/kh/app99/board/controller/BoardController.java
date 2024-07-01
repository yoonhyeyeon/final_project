package com.kh.app99.board.controller;

import com.kh.app99.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    //게시글 작성
    @GetMapping("write")
    public void m01(){}

    //게시글 상세조회
    @GetMapping("detail")
    public void m02(){}

    //게시글 삭제
    @GetMapping("delete")
    public String m03(){
        return "board/delete";
    }




}
