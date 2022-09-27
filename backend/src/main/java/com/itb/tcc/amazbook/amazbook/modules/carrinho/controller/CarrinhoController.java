package com.itb.tcc.amazbook.amazbook.modules.carrinho.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itb.tcc.amazbook.amazbook.modules.carrinho.service.CarrinhoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/carrinho")
@RequiredArgsConstructor
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    @PostMapping(value = "/{idLivro}")
    public String addLivroCarrinho(@PathVariable Integer idLivro, @CookieValue("carrinho")
            Optional<String> jsonCarrinho, HttpServletResponse response) throws JsonProcessingException {

        return carrinhoService.addLivroCarrinho(idLivro, jsonCarrinho, response);
    }
}
