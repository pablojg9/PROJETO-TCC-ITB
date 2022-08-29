package com.itb.tcc.amazbook.amazbook.modules.livro.repository;

import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findByNameContainingIgnoreCase(String name);
}
