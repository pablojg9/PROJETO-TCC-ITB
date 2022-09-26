package com.itb.tcc.amazbook.amazbook.modules.livro.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LivroRequest {

    private String name;
    private String author;
    @JsonProperty("editora")
    private String publishingCompany;
    @JsonProperty("value_book")
    private Double valueBook;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;
    private Integer categoryId;

}
