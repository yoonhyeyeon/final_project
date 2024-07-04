package com.kh.app.file.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileStorageService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    // 폴더 생성
    public void init() {
        try {
            Files.createDirectories(Paths.get(uploadDir));
        } catch (IOException e) {
            throw new RuntimeException("[F-000 폴더 생성 실패]");
        }
    } // init

    // 파일 조회
    public Path loadFile(String filename) {
        return Paths.get(uploadDir).resolve(filename);
    } // loadFile

    // 모든 파일 조회
    public Stream<Path> loadAllFile() {
        try {
            return Files.walk(Paths.get(uploadDir), 1)
                    .filter(path -> !path.equals(Paths.get(uploadDir)))
                    .map(Paths.get(uploadDir)::relativize);
        } catch (IOException e) {
            throw new RuntimeException("[F-002 모든 파일 조회 실패]");
        }
    } // loadAllFile

    // 파일 업로드
    public String saveFile(MultipartFile file) {
        try {
            Path path = Paths.get(uploadDir, file.getOriginalFilename());
            Files.copy(file.getInputStream(), path);
            return file.getOriginalFilename();
        } catch (IOException e) {
            throw new RuntimeException("[F-001 파일 업로드 실패]");
        }
    } // saveFile
    
    // 파일 삭제
    public void deleteFile(String filename) {
        try {
            Path file = loadFile(filename);
            Files.deleteIfExists(file);
        } catch (IOException e) {
            throw new RuntimeException("[F-003 파일 삭제 실패]");
        }
    } // deleteFile
} // class
