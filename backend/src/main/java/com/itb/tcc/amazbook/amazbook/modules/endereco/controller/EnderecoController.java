package com.itb.tcc.amazbook.amazbook.modules.endereco.controller;

import com.itb.tcc.amazbook.amazbook.modules.endereco.dto.EnderecoRequest;
import com.itb.tcc.amazbook.amazbook.modules.endereco.dto.EnderecoResponse;
import com.itb.tcc.amazbook.amazbook.modules.endereco.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<EnderecoResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<EnderecoResponse> save(@RequestBody EnderecoRequest enderecoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoRequest));
    }
}
