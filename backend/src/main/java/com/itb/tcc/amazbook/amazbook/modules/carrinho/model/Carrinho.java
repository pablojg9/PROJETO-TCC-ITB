package com.itb.tcc.amazbook.amazbook.modules.carrinho.model;

import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Data
public class Carrinho {

    private List<LivroResponse> livros = new ArrayList<>();
    public void adiciona(Livro livro) {

        livros.add(new LivroResponse(livro));

    }
}
