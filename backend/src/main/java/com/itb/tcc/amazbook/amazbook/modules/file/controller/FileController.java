package com.itb.tcc.amazbook.amazbook.modules.file.controller;

import com.itb.tcc.amazbook.amazbook.modules.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {


    private final FileService fileService;

    @PostMapping (value = "/uploadFile", consumes = "multipart/form-data")
    public ResponseEntity<Object> uploadFile( @RequestParam ("File") MultipartFile file) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED).body("Arquivo criado: " + fileService.uploadFile(file));
    }
}
