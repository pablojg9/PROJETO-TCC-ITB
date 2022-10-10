package com.itb.tcc.amazbook.amazbook.modules.file.dto;

import com.itb.tcc.amazbook.amazbook.modules.file.model.FilesBook;
import com.itb.tcc.amazbook.amazbook.modules.livro.dto.LivroResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileResponse {

    private Integer id;
    private String fileName;
    private Byte[] data;
    private String type;
    private LivroResponse livro;

    public static FileResponse of(FilesBook filesBook) {
        return FileResponse
                .builder()
                .id(filesBook.getId())
                .fileName(filesBook.getFileName())
                .data(filesBook.getData())
                .type(filesBook.getType())
                .livro(LivroResponse.of(filesBook.getLivro()))
                .build();
    }
}
