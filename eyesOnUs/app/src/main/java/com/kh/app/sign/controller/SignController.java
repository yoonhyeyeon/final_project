package com.kh.app.sign.controller;

import com.kh.app.member.vo.MemberVo;
import com.kh.app.sign.service.SignService;
import com.kh.app.sign.vo.SignVo;
import jakarta.servlet.http.HttpSession;
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

    // 기안 (화면)
    @GetMapping("write")
    public void signWrite(){} // showWrite

    // 기안
    @PostMapping("write")
    public String signWrite(SignVo vo, HttpSession session) throws IOException {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String empNo = loginMemberVo.getNo();
        vo.setEmpNo(empNo);

        MultipartFile file = vo.getFile();
        if(!file.isEmpty()){
            // 저장할 경로, 원래  파일명, 사이즈
            String uploadDir = "C:\\Users\\seong\\project\\final\\eyesOnUs\\app\\src\\main\\resources\\static\\sign\\";
            String originName = file.getOriginalFilename();
            String size = String.valueOf(file.getSize());

            // 저장할 파일명
            int random = (int) (Math.random() * 90000) + 10000;
            String ext = originName.substring(originName.lastIndexOf("."));
            String changeName = "SIGN_" + System.nanoTime() + "_" + random + ext;

            String fullPath = uploadDir + changeName;
            File targetFile = new File(fullPath);
            file.transferTo(targetFile);

            vo.setSize(size);
            vo.setOriginName(originName);
            vo.setChangeName(changeName);
        }
        int signWriteResult = service.signWrite(vo);

        if(signWriteResult == 0){
            session.setAttribute("alertMsg", "기안 실패");
            return "redirect:/sign/write";
        }

        session.setAttribute("alertMsg", "기안 완료");

        return "redirect:/sign/listForWriter";
    } // signWrite

    // 결재 목록 조회 (기안자 입장) (화면)
    @GetMapping("listForWriter")
    public String signListForWriter(){
        return "sign/list/listForWriter";
    } // signListForWriter

    // 결재 목록 조회 (결재자 입장) (화면)
    @GetMapping("listForApprover")
    public String signListForApprover(){
        return "sign/list/listForApprover";
    } // signListForApprover

    // 결재 목록 조회 (참조자 입장) (화면)
    @GetMapping("listForReference")
    public String signListForReference(){
        return "sign/list/listForReference";
    } // signListForReference

    // 결재 상세 조회 (화면)
    @GetMapping("detail")
    public void signDetail(){} // signDetail
} // class
