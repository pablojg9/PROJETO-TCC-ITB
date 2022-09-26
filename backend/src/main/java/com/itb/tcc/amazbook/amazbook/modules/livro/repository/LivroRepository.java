package com.itb.tcc.amazbook.amazbook.modules.livro.repository;

import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Integer> {

    List<Livro> findByNameContainingIgnoreCase(String name);

    @Modifying
    @Query("delete from Livro u where u.id in ?1")
    void deleteRemedioByWithId(Integer id);
}
