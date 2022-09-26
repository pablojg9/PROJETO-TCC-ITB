package com.itb.tcc.amazbook.amazbook.modules.livro.model;

import com.itb.tcc.amazbook.amazbook.modules.category.model.Category;
import com.itb.tcc.amazbook.amazbook.modules.livro.dto.LivroRequest;
import com.itb.tcc.amazbook.amazbook.modules.user.model.Usuario;
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
@Table(name = "LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME_LIVRO", length = 120)
    private String name;

    @Column(name = "AUTOR", nullable = false, length = 120)
    private String author;

    @Column(name = "EDITORA", nullable = false, length = 200)
    //editora
    private String publishingCompany;

    @Column(name = "VALOR_LIVRO")
    private Double valueBook;

    // Data de publicação
    @Column(name = "DATA_PUBLICACAO", updatable = false)
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "FK_CATEGORY", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "FK_USUARIO")
    private Usuario usuario;

    @PrePersist
    public void getPersist() {
        //System.out.println(LocalDate.now());
        publicationDate = LocalDate.now();
    }

    public static Livro of(LivroRequest livroRequest, Category category) {
        Livro livro = new Livro();
        BeanUtils.copyProperties(livroRequest, livro);
        return Livro
                .builder()
                .name(livroRequest.getName())
                .author(livroRequest.getAuthor())
                .publishingCompany(livroRequest.getPublishingCompany())
                .valueBook(livroRequest.getValueBook())
                .publicationDate(livroRequest.getPublicationDate())
                .category(category)
                .build();
    }
}
