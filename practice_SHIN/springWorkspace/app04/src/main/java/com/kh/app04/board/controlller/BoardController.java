package com.kh.app04.board.controlller;

import com.kh.app04.board.service.BoardService;
import com.kh.app04.board.vo.BoardVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

@Controller
//@RestController
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService service;

    //게시글 작성 (화면)
    @GetMapping("write")
    public String write(){
    return "board/write";
    }
    
    //게시글 작성 (파일업로드 포함)
    @PostMapping("insert")
    public void insert(BoardVo vo) throws Exception{
        System.out.println("vo = " + vo);

       List<MultipartFile> attachmentList =  vo.getAttachmentList();
       for(MultipartFile att : attachmentList){
           System.out.println("att = " + att);
       }

    }

    //게시글 작성
    @PostMapping("write")
    @ResponseBody
    public int write(BoardVo vo){
        int result = service.write(vo);
        return result;
    }

    //게시글 목록조회
    @GetMapping("list")
    @ResponseBody
    public List<BoardVo> getBoardList(){
        List<BoardVo> voList = service.getBoardList();
        return voList;
    }

    @GetMapping("search")
    @ResponseBody
    public List<BoardVo> getBoardList(@RequestParam Map<String, String> paramMap){
        System.out.println("paramMap = " + paramMap);
        List<BoardVo> voList= service.searchBoardList(paramMap);
        return voList;
    }//method

}
