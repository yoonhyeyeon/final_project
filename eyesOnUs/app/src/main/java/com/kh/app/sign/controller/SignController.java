package com.kh.app.sign.controller;

import com.kh.app.sign.service.SignService;
import com.kh.app.sign.vo.SignVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("sign")
public class SignController {

    private final SignService service;

    // 결재 신청 (화면)
    @GetMapping("write")
    public void signWrite(){} // showWrite

    // 결재 신청
    @PostMapping("write")
    public String signWrite(SignVo vo) throws IOException {
        MultipartFile file = vo.getFile();
        if(!file.isEmpty()){

            // 저장할 경로, 원래  파일명, 사이즈
            String uploadDir = "C:\\Users\\seong\\project\\final_test\\back\\final\\src\\main\\resources\\static\\file\\sign\\";
            String originName = file.getOriginalFilename();
            String size = String.valueOf(file.getSize());

            // 저장할 파일명
            int random = (int) (Math.random() * 90000) + 10000;
            String ext = originName.substring(originName.lastIndexOf("."));
            String changeName = "SIGN_" + System.nanoTime() + "_" + random + ext;

            String fullPath = uploadDir + changeName;
            file.transferTo(new File(fullPath));

            vo.setSize(size);
            vo.setOriginName(originName);
            vo.setChangeName(changeName);
        }
        int result = service.signWrite(vo);
        return "redirect:/home";
    } // signWrite

    // 결재 목록 조회 (화면)
    @GetMapping("list")
    public void signList(){} // signList

    // 결재 상세 조회 (화면)
    @GetMapping("detail")
    public void signDetail(){} // signDetail
} // class
