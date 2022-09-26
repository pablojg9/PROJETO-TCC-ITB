package com.itb.tcc.amazbook.amazbook.modules.carrinho.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itb.tcc.amazbook.amazbook.modules.carrinho.model.Carrinho;
import com.itb.tcc.amazbook.amazbook.modules.livro.repository.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/carrinho")
@RequiredArgsConstructor
public class CarrinhoController {

    private final LivroRepository livroRepository;

    @PostMapping(value = "/{idLivro}")
    public String addLivroCarrinho(@PathVariable Integer idLivro, @CookieValue("carrinho")
                    Optional<String> jsonCarrinho, HttpServletResponse response) throws JsonProcessingException {

        Carrinho carrinho = jsonCarrinho.map(json -> {
            try {
                return new ObjectMapper().readValue(json, Carrinho.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).orElse(new Carrinho());

        carrinho.adiciona(livroRepository.findById(idLivro).get());

        Cookie cookie = new Cookie("carrinho", new ObjectMapper().writeValueAsString(carrinho));
        cookie.setHttpOnly(true);

        response.addCookie(cookie);

        return carrinho.toString();
    }
}
