package com.itb.tcc.amazbook.amazbook.modules.file.service;

import com.itb.tcc.amazbook.amazbook.exceptions.ValidationException;
import com.itb.tcc.amazbook.amazbook.modules.file.dto.FileRequest;
import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import com.itb.tcc.amazbook.amazbook.modules.file.repository.FileRepository;
import com.itb.tcc.amazbook.amazbook.modules.livro.repository.LivroRepository;
import com.itb.tcc.amazbook.amazbook.utils.ErrorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class FileService  {

    private final FileRepository fileRepository;

    private final LivroRepository livroRepository;


    @Value("file.upload-file")
    private String FILE_DIRECTORY;

    public FilesBook findById(Integer id) {
        validateInformedId(id);
        return fileRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException(ErrorUtil.FILE_NOT_FOUND));

    }

    private void validateInformedId(Integer id) {
        if(isEmpty(id)) {
            throw new ValidationException(ErrorUtil.ID_EMPTY);
        }
    }

    //TODO - FAZER O UPLOAD DA IMAGE DO LIVRO.

    public Object uploadFile(MultipartFile file) throws IOException {
        File convertFile = new File( FILE_DIRECTORY + file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        return convertFile;
    }
}
