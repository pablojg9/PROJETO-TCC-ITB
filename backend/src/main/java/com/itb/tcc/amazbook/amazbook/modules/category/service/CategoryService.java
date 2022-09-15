package com.itb.tcc.amazbook.amazbook.modules.category.service;


import com.itb.tcc.amazbook.amazbook.exceptions.SuccessResponse;
import com.itb.tcc.amazbook.amazbook.exceptions.ValidationException;
import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryRequest;
import com.itb.tcc.amazbook.amazbook.modules.category.dto.CategoryResponse;
import com.itb.tcc.amazbook.amazbook.modules.category.model.Category;
import com.itb.tcc.amazbook.amazbook.modules.category.repository.CategoryRepository;
import com.itb.tcc.amazbook.amazbook.utils.ErrorUtil;
import com.itb.tcc.amazbook.amazbook.utils.SuccessUtil;
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

    public Category findById(Integer id) {
        validateInformedId(id);
        return categoryRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException(ErrorUtil.ID_EMPTY));
    }

    public CategoryResponse findByIdResponse(Integer id){
        return CategoryResponse
                .of(findById(id));
    }

    public SuccessResponse deleteById(Integer id) {
        validateInformedId(id);
        categoryRepository
                .deleteById(id);

        return SuccessResponse
                .create(SuccessUtil.DELETE_SUCCESS);
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

    public CategoryResponse update(CategoryRequest categoryRequest, Integer id) {
        validateBookDataInformed(categoryRequest);
        validateInformedId(id);

        Category category = Category.of(categoryRequest);
        category.setId(id);
        categoryRepository.save(category);
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
