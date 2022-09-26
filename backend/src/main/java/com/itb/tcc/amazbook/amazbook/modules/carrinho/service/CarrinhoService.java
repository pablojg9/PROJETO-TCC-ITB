package com.itb.tcc.amazbook.amazbook.modules.carrinho.service;

import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import com.itb.tcc.amazbook.amazbook.modules.livro.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CarrinhoService {

    double a = 0;
    private Integer posicao = 0;

    private final LivroRepository livroRepository;

    private Set<Livro> livros = new HashSet<>();


}
