package com.itb.tcc.amazbook.amazbook.modules.book.controller;

import com.itb.tcc.amazbook.amazbook.config.exception.SuccessResponse;
import com.itb.tcc.amazbook.amazbook.modules.book.dto.BookRequest;
import com.itb.tcc.amazbook.amazbook.modules.book.dto.BookResponse;
import com.itb.tcc.amazbook.amazbook.modules.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping
    public List<BookResponse> findAll() {
        return bookService.findAll();
    }

    @PostMapping
    public BookResponse save(@RequestBody BookRequest bookRequest) {
        return bookService.save(bookRequest);
    }

    @GetMapping("name/{name}")
    public List<BookResponse> findByName(@PathVariable String name) {
        return bookService.findByName(name);
    }

    @GetMapping("{id}")
    public BookResponse findById(@PathVariable Integer id) {
        return bookService.findByIdResponse(id);
    }

    @DeleteMapping("{id}")
    public SuccessResponse deleteById(@PathVariable Integer id) {
        return bookService.deleteById(id);
    }
}
