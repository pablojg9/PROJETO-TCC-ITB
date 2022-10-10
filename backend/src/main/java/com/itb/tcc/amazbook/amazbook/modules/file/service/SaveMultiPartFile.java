package com.itb.tcc.amazbook.amazbook.modules.file.service;

import com.itb.tcc.amazbook.amazbook.modules.file.dto.FileRequest;
import org.springframework.web.multipart.MultipartFile;

public interface SaveMultiPartFile {

    FileRequest save(MultipartFile files, String idLivro);

}
