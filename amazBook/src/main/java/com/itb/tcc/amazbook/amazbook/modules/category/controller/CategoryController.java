package com.itb.tcc.amazbook.amazbook.modules.category.controller;

import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryRequest;
import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryResponse;
import com.itb.tcc.amazbook.amazbook.modules.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<CategoryResponse>> findByNameCategory(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findByNameCategory(name));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.save(categoryRequest));

    }
}
