package com.kh.app.sign.controller;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.kh.app.member.vo.MemberVo;
import com.kh.app.sign.service.SignService;
import com.kh.app.sign.vo.SignVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/sign")
public class SignRestController {
    
    private final SignService service;

    private final AmazonS3 s3;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    @Value("${path}")
    private String path;
    
    // 직원 전체 목록 조회 (API)
    @GetMapping("employeeList")
    public Map<String, List> getEmployeeList(){
        Map<String, List> employeeListMap = service.getEmployeeList();

        return employeeListMap;
    } // getEmployeeList

    // 결재 목록 조회 (기안자 입장) (API)
    @GetMapping("listForWriter")
    public Map<String, List> getSignListForWriter(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String empNo = loginMemberVo.getNo();
        
        Map<String, List> signListMapForWriter = service.getSignListForWriter(empNo);

        return signListMapForWriter;
    } // getSignListForWriter
    
    // 결재 목록 조회 (결재자 입장) (API)
    @GetMapping("listForApprover")
    public Map<String, List> getSignListForApprover(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String approverNo = loginMemberVo.getNo();

        Map<String, List> signListMapForApprover = service.getSignListForApprover(approverNo);

        return signListMapForApprover;
    } // getSignListForApprover

    // 결재 목록 조회 (참조자 입장) (API)
    @GetMapping("listForReference")
    public Map<String, List> getSignListForReference(@SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        String refNo = loginMemberVo.getNo();

        Map<String, List> signListMapForReference = service.getSignListForReference(refNo);

        return signListMapForReference;
    } // getSignListForReference

    // 결재 상세 조회 (API)
    @GetMapping("detail")
    public Map<String, SignVo> getSignDetail(SignVo signVo, @SessionAttribute("loginMemberVo") MemberVo loginMemberVo){
        Map<String, SignVo> signDetailMap = service.getSignDetail(signVo, loginMemberVo);

        return signDetailMap;
    } // getSignDetail

    // 결재자, 참조자 상세 조회 (API)
    @GetMapping("detailList")
    public Map<String, List> getSignApproverAndReferenceDetailList(SignVo signVo){
        Map<String, List> signApproverAndReferenceDetailMap = service.getSignApproverDetailList(signVo);

        return signApproverAndReferenceDetailMap;
    } // getSignApproverAndReferenceDetailList

    // 결재 (API)
    @PutMapping("approve")
    public Map<String, Integer> updateSignApprove(SignVo signVo) throws IOException {
        MultipartFile file = signVo.getFile();
        if(file != null && !file.isEmpty()){
            String size = String.valueOf(file.getSize());
            signVo.setSize(size);

            // 로컬에 파일 저장
//            String uploadDir = path;
//            String fullPath = uploadDir + file.getOriginalFilename();
//            File targetFile = new File(fullPath);
//            file.transferTo(targetFile);
//            signVo.setChangeName(file.getOriginalFilename());

            // AWS S3의 기존 파일 삭제
            String str = signVo.getChangeName().substring(61, signVo.getChangeName().length());
            s3.deleteObject(bucketName, str);

            // AWS S3에 새로운 파일 저장
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(file.getContentType());
            metadata.setContentLength(file.getSize());
            s3.putObject(bucketName, file.getOriginalFilename(), file.getInputStream(), metadata);
            URL url = s3.getUrl(bucketName, file.getOriginalFilename());
            String filePath = String.valueOf(url);

            signVo.setChangeName(filePath);
        }

        Map<String, Integer> signApproveResultMap = service.updateSignApprove(signVo);

        return signApproveResultMap;
    } // updateSignApprove
} // class
