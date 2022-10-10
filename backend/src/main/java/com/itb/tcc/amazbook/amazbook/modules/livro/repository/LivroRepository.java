package com.itb.tcc.amazbook.amazbook.modules.livro.repository;

import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findByNameContainingIgnoreCase(String name);

    @Modifying
    @Query("delete from Livro u where u.id in ?1")
    void deletelivroByWithId(Integer id);

    List<Livro> findByCategoryId(Integer id);

    void findById(UUID fromString);
}
