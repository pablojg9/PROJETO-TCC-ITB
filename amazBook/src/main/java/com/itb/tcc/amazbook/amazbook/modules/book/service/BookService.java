package com.itb.tcc.amazbook.amazbook.modules.book.service;

import com.itb.tcc.amazbook.amazbook.config.exception.SuccessResponse;
import com.itb.tcc.amazbook.amazbook.config.exception.ValidationException;
import com.itb.tcc.amazbook.amazbook.modules.book.dto.BookRequest;
import com.itb.tcc.amazbook.amazbook.modules.book.dto.BookResponse;
import com.itb.tcc.amazbook.amazbook.modules.book.model.Book;
import com.itb.tcc.amazbook.amazbook.modules.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class BookService {

    private static final Double ZERO = 0.0;
    private final BookRepository bookRepository;

    public List<BookResponse> findAll() {
        return bookRepository
                .findAll()
                .stream()
                .map(BookResponse::of)
                .collect(Collectors.toList());
    }

    public BookResponse save(BookRequest bookRequest) {
        validateBookDataInformed(bookRequest);

        Book book = bookRepository.save(Book.of(bookRequest));

        return BookResponse.of(book);
    }


    public SuccessResponse deleteById(Integer id) {
        validateInformedId(id);

        bookRepository
                .deleteById(id);

        return SuccessResponse
                .create("Livro deletado com sucesso");
    }

    public List<BookResponse> findByName(String name) {
        if (isEmpty(name)) {
            throw new ValidationException("O Livro não foi informado.");
        }

        return bookRepository
                .findByNameContainingIgnoreCase(name)
                .stream()
                .map(BookResponse::of)
                .collect(Collectors.toList());
    }

    public Book findById(Integer id) {
        validateInformedId(id);
        return bookRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("O id do livro não fornecido"));
    }

    public BookResponse findByIdResponse(Integer id) {
        return BookResponse
                .of(findById(id));
    }

    public void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("O id Livro não foi informado");
        }
    }

    private void validateBookDataInformed(BookRequest bookRequest) {
        if (isEmpty(bookRequest.getName())) {
            throw new ValidationException("O nome do livro não pode estar vazio!.");
        }

        if (isEmpty(bookRequest.getAuthor())) {
            throw new ValidationException("A editora não pode estar vazio!");
        }

        if (isEmpty(bookRequest.getValueBook() <= ZERO)) {
            throw new ValidationException("O valor do Livro não pode ser 0.");
        }
    }
}
