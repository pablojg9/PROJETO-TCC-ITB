package com.itb.tcc.amazbook.amazbook.modules.endereco.repository;

import com.itb.tcc.amazbook.amazbook.modules.endereco.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
