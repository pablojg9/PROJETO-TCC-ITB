package com.itb.tcc.amazbook.amazbook.modules.file.dto;

import lombok.Data;

@Data
public class FileRequest {

    private String fileName;
    private Byte[] data;
    private String type;
    private Integer livroId;
}
