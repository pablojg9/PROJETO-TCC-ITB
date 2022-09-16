package com.itb.tcc.amazbook.amazbook.modules.livro.controller;

import com.itb.tcc.amazbook.amazbook.exceptions.SuccessResponse;
import com.itb.tcc.amazbook.amazbook.modules.livro.dto.LivroRequest;
import com.itb.tcc.amazbook.amazbook.modules.livro.dto.LivroResponse;
import com.itb.tcc.amazbook.amazbook.modules.livro.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
@RequiredArgsConstructor
public class LivroController {

    private final LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.findAll());
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<LivroResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.findByIdResponse(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<LivroResponse>> findByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.findByNameBook(name));
    }

    @PostMapping
    public ResponseEntity<LivroResponse> save(@RequestBody LivroRequest livroRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.save(livroRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LivroResponse> update(@RequestBody LivroRequest livroRequest, @PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.update(livroRequest, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<SuccessResponse> deleteById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.deleteById(id));
    }
}
