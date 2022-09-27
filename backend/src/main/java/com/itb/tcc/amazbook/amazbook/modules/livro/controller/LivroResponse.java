package com.itb.tcc.amazbook.amazbook.modules.livro.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryResponse;
import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroResponse {

    private Integer id;
    private String name;
    private String author;
    private String publishingCompany;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;
    private Double valueBook;
    private CategoryResponse category;

    public LivroResponse(Livro livro) {
        name = livro.getName();
        author = livro.getAuthor();
        valueBook = livro.getValueBook();
    }

    public static LivroResponse of(Livro livro) {
        return LivroResponse
                .builder()
                .id(livro.getId())
                .name(livro.getName())
                .author(livro.getAuthor())
                .publishingCompany(livro.getPublishingCompany())
                .valueBook(livro.getValueBook())
                .category(CategoryResponse.of(livro.getCategory()))
                .build();
    }
}
