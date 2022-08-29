package com.itb.tcc.amazbook.amazbook.modules.user.repository;

import com.itb.tcc.amazbook.amazbook.modules.user.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
