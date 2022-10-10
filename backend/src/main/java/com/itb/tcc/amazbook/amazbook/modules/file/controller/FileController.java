package com.itb.tcc.amazbook.amazbook.modules.file.controller;

import com.itb.tcc.amazbook.amazbook.modules.file.dto.FileRequest;
import com.itb.tcc.amazbook.amazbook.modules.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/api/file")
@RequiredArgsConstructor
public class FileController {

    @Value("file.upload-file")
    private String FILE_DIRECTORY ;

    @PostMapping (value = "/uploadFile", consumes = "multipart/form-data")
    public ResponseEntity<Object> uploadFile( @RequestParam ("File") MultipartFile file) throws IOException {
        File convertFile = new File( FILE_DIRECTORY + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return new ResponseEntity<Object>("O Arquivo Carregado com Sucesso.", HttpStatus.OK);
    }
}
