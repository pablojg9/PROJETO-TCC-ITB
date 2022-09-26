package com.itb.tcc.amazbook.amazbook.modules.category.controller;


import com.itb.tcc.amazbook.amazbook.exceptions.SuccessResponse;
import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryRequest;
import com.itb.tcc.amazbook.amazbook.modules.carrinho.model.CategoryResponse;
import com.itb.tcc.amazbook.amazbook.modules.category.service.CategoryService;
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
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<CategoryResponse>> findByNameCategory(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findByNameCategory(name));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findByIdResponse(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CategoryResponse> update(@RequestBody CategoryRequest categoryRequest, @PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(categoryRequest, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SuccessResponse> deleteById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.deleteById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(categoryRequest));
    }
}
