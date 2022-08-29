package com.itb.tcc.amazbook.amazbook.modules.book.service;

import com.itb.tcc.amazbook.amazbook.config.exception.SuccessResponse;
import com.itb.tcc.amazbook.amazbook.config.exception.ValidationException;
import com.itb.tcc.amazbook.amazbook.modules.book.dto.LivroRequest;
import com.itb.tcc.amazbook.amazbook.modules.book.dto.LivroResponse;
import com.itb.tcc.amazbook.amazbook.modules.book.model.Livro;
import com.itb.tcc.amazbook.amazbook.modules.book.repository.LivroRepository;
import com.itb.tcc.amazbook.amazbook.util.ErrorUtil;
import com.itb.tcc.amazbook.amazbook.util.SuccessUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class LivroService {

    private static final Double ZERO = 0.0;
    private final LivroRepository livroRepository;

    public List<LivroResponse> findAll() {
        return livroRepository
                .findAll()
                .stream()
                .map(LivroResponse::of)
                .collect(Collectors.toList());
    }

    public LivroResponse save(LivroRequest livroRequest) {
        validateBookDataInformed(livroRequest);

        Livro livro = livroRepository.save(Livro.of(livroRequest));

        return LivroResponse.of(livro);
    }


    public SuccessResponse deleteById(Integer id) {
        validateInformedId(id);

        livroRepository
                .deleteById(id);

        return SuccessResponse
                .create(SuccessUtil.DELETE_SUCCESS);
    }

    public List<LivroResponse> findByNameBook(String name) {
        validateNameBook(name);
        return livroRepository
                .findByNameContainingIgnoreCase(name)
                .stream()
                .map(LivroResponse::of)
                .collect(Collectors.toList());
    }

    public Livro findById(Integer id) {
        validateInformedId(id);
        return livroRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException(ErrorUtil.ID_EMPTY));
    }

    public LivroResponse findByIdResponse(Integer id) {
        return LivroResponse
                .of(findById(id));
    }

    private void validateNameBook(String name){
        if(isEmpty(name)){
            throw new ValidationException(ErrorUtil.NAME_EMPTY_BOOK);
        }
    }

    private void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException(ErrorUtil.ID_EMPTY);
        }
    }

    private void validateBookDataInformed(LivroRequest livroRequest) {
        if (isEmpty(livroRequest.getName())) {
            throw new ValidationException(ErrorUtil.NAME_EMPTY_BOOK);
        }

        if (isEmpty(livroRequest.getAuthor())) {
            throw new ValidationException(ErrorUtil.EMPTY_PUBLISHER);
        }
    }
}
