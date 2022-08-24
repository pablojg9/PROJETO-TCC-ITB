package com.itb.tcc.amazbook.amazbook.modules.book.repository;

import com.itb.tcc.amazbook.amazbook.modules.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByNameContainingIgnoreCase(String name);

}
