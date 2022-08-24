package com.itb.tcc.amazbook.amazbook.modules.book.model;

import com.itb.tcc.amazbook.amazbook.modules.book.dto.BookRequest;
import com.itb.tcc.amazbook.amazbook.modules.category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME_LIVRO")
    private String name;

    @Column(name = "AUTOR", nullable = false)
    private String author;

    @Column(name = "EDITORA", nullable = false)
    //editora
    private String publishingCompany;

    @Column(name = "VALOR_LIVRO")
    private Double valueBook;

    // Data de publicação
    @Column(name = "DATA_PUBLICACAO", nullable = false, updatable = false)
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY", nullable = false)
    private Category category;

    @PrePersist
    public void getPersist() {
        publicationDate = LocalDate.now();
    }

    public static Book of(BookRequest bookRequest) {
        Book book = new Book();
        BeanUtils.copyProperties(bookRequest, book);
        return book;
    }
}
