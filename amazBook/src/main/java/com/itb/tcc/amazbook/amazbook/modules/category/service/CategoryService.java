package com.itb.tcc.amazbook.amazbook.modules.category.service;

import com.itb.tcc.amazbook.amazbook.config.exception.ValidationException;
import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryRequest;
import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryResponse;
import com.itb.tcc.amazbook.amazbook.modules.category.model.Category;
import com.itb.tcc.amazbook.amazbook.modules.category.repository.CategoryRepository;
import com.itb.tcc.amazbook.amazbook.util.ErrorUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponse> findAll() {
        return categoryRepository
                .findAll()
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public List<CategoryResponse> findByNameCategory(String nameCategory) {
        validateNameCategory(nameCategory);
        return categoryRepository
                .findByNameCategoryContainingIgnoreCase(nameCategory)
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public CategoryResponse save(CategoryRequest categoryRequest) {
        validateBookDataInformed(categoryRequest);

        Category category = categoryRepository.save(Category.of(categoryRequest));

        return CategoryResponse.of(category);
    }

    private void validateNameCategory(String name) {
        if(isEmpty(name)){
            throw new ValidationException(ErrorUtil.NAME_EMPTY_BOOK);
        }

    }
    private void validateInformedId(Integer id) {
        if(isEmpty(id)) {
            throw new ValidationException(ErrorUtil.ID_EMPTY);
        }
    }

    private void validateBookDataInformed(CategoryRequest categoryRequest) {
        if (isEmpty(categoryRequest.getNameCategory())) {
            throw new ValidationException(ErrorUtil.NAME_EMPTY_BOOK);
        }
    }
}
