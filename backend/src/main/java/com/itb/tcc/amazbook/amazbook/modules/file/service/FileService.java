package com.itb.tcc.amazbook.amazbook.modules.file.service;

import com.itb.tcc.amazbook.amazbook.exceptions.ValidationException;
import com.itb.tcc.amazbook.amazbook.modules.file.dto.FileRequest;
import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import com.itb.tcc.amazbook.amazbook.modules.file.repository.FileRepository;
import com.itb.tcc.amazbook.amazbook.modules.livro.repository.LivroRepository;
import com.itb.tcc.amazbook.amazbook.utils.ErrorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class FileService implements SaveMultiPartFile {

    private final FileRepository fileRepository;

    private final LivroRepository livroRepository;

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

    @Override
    public FileRequest save(MultipartFile files, String idLivro) {
        try {
            uploadFile(files, idLivro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO - FAZER O UPLOAD DA IMAGE DO LIVRO.

    private void uploadFile(MultipartFile files, String idLivro) throws IOException {
        byte[] data = files.getBytes();
        String fileName = files.getOriginalFilename();
        String type = files.getContentType();

        livroRepository.findById(UUID.fromString(idLivro));

    }
}
