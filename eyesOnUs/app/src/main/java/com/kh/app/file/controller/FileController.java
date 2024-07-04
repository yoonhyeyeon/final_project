package com.kh.app.file.controller;

import com.kh.app.file.service.FileStorageService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("file")
@RequiredArgsConstructor
public class FileController {

    private final FileStorageService fileStorageService;

    // 폴더 생성
    @PostConstruct
    public void init() {
        fileStorageService.init();
    }

    // 모든 파일 조회
    @GetMapping
    public ResponseEntity<List<String>> listFiles() {
        List<String> fileNames = fileStorageService.loadAllFile()
                .map(path -> path.getFileName().toString())
                .collect(Collectors.toList());
        return ResponseEntity.ok(fileNames);
    } // listFiles

    // 파일 업로드
    @PostMapping("upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String filename = fileStorageService.saveFile(file);
        return ResponseEntity.ok("File uploaded successfully: " + filename);
    } // uploadFile

    // 파일 다운로드
    @GetMapping("download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Path file = fileStorageService.loadFile(filename);
        Resource resource;
        try {
            resource = new UrlResource(file.toUri());
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    } // downloadFile

    // 파일 삭제
    @DeleteMapping("delete/{filename:.+}")
    public ResponseEntity<String> deleteFile(@PathVariable String filename) {
        fileStorageService.deleteFile(filename);
        return ResponseEntity.ok("File deleted successfully: " + filename);
    } // deleteFile
} // class
