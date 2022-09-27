package com.itb.tcc.amazbook.amazbook.modules.carrinho.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itb.tcc.amazbook.amazbook.modules.livro.controller.LivroResponse;
import com.itb.tcc.amazbook.amazbook.modules.livro.model.Livro;
import com.itb.tcc.amazbook.amazbook.modules.livro.repository.LivroRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
@ToString
public class CarrinhoService {

    private List<LivroResponse> livros = new ArrayList<>();

    @Autowired
    private LivroRepository livroRepository;

    public void addLivro(Livro livro) {
        livros.add(new LivroResponse(livro));
    }

    public String addLivroCarrinho(Integer idLivro, Optional<String> jsonCarrinho, HttpServletResponse response)
            throws JsonProcessingException {

        var carrinho = jsonCarrinho.map(json -> {
            try {
                return new ObjectMapper().readValue(json, CarrinhoService.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).orElse(new CarrinhoService());

        carrinho.addLivro(livroRepository.findById(idLivro).get());

        Cookie cookie = new Cookie("carrinho", new ObjectMapper().writeValueAsString(carrinho));
        cookie.setHttpOnly(true);
        response.addCookie(cookie);

        return carrinho.toString();
    }
}
