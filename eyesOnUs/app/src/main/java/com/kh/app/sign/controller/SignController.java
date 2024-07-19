package com.kh.app.sign.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.sign.service.SignService;
import com.kh.app.sign.vo.SignVo;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;

@Controller
@RequiredArgsConstructor
@RequestMapping("sign")
public class SignController {

    private final SignService service;
    private final AmazonS3 s3;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Value("${path}")
    private String path;

    // 기안 (화면)
    @GetMapping("write")
    public void signWrite(){} // showWrite

    // 기안
    @PostMapping("write")
    public String signWrite(SignVo signVo, HttpSession session) throws IOException {
        MemberVo loginMemberVo = (MemberVo) session.getAttribute("loginMemberVo");
        String empNo = loginMemberVo.getNo();
        signVo.setEmpNo(empNo);
        MultipartFile file = signVo.getFile();

        if(file != null && !file.isEmpty()){
            // 저장할 경로, 원래  파일명, 사이즈
            String originName = file.getOriginalFilename();
            String size = String.valueOf(file.getSize());

            // 저장할 파일명
            int random = (int) (Math.random() * 90000) + 10000;
            String ext = originName.substring(originName.lastIndexOf("."));
            String changeName = "SIGN_" + System.nanoTime() + "_" + random + ext;

            // 로컬에 파일 저장
//            String uploadDir = path;
//            String fullPath = uploadDir + changeName;
//            File targetFile = new File(fullPath);
//            file.transferTo(targetFile);
//            signVo.setChangeName(fullPath);

            // AWS S3에 파일 저장
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());
            s3.putObject(bucketName, changeName, file.getInputStream(), metadata);
            URL url = s3.getUrl(bucketName, changeName);
            String filePath = String.valueOf(url);

            signVo.setSize(size);
            signVo.setOriginName(originName);
            signVo.setChangeName(filePath);
        }
        int signWriteResult = service.signWrite(signVo);

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
    public String signDetail(Model model, SignVo signVo){
        // 결재 상세 조회할 signNo 넘겨주기
        model.addAttribute("signVo", signVo);
        return "sign/detail";
    } // signDetail
} // class
