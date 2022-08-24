package com.itb.tcc.amazbook.amazbook.modules.book.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryResponse;
import com.itb.tcc.amazbook.amazbook.modules.book.model.Book;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BookResponse {

    private Integer id;
    private String author;
    private String publishingCompany;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;
    private Double valueBook;
    private CategoryResponse category;

    public static BookResponse of(Book book) {
        return BookResponse
                .builder()
                .id(book.getId())
                .author(book.getAuthor())
                .publishingCompany(book.getPublishingCompany())
                .valueBook(book.getValueBook())
                .category(CategoryResponse.of(book.getCategory()))
                .build();
    }
}
