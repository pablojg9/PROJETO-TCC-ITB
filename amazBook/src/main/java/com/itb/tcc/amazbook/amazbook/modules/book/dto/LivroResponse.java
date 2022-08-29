package com.itb.tcc.amazbook.amazbook.modules.book.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryResponse;
import com.itb.tcc.amazbook.amazbook.modules.book.model.Livro;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class LivroResponse {

    private Integer id;
    private String name;
    private String author;
    private String publishingCompany;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;
    private Double valueBook;
    private CategoryResponse category;

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
