package com.itb.tcc.amazbook.amazbook.modules.book.dto;

import lombok.Data;

@Data
public class BookRequest {

    private String name;
    private String author;
    private Integer categoryId;
    private Double valueBook;
}
