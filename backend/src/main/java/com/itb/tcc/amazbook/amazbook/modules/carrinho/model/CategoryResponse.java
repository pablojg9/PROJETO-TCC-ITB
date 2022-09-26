package com.itb.tcc.amazbook.amazbook.modules.carrinho.model;

import com.itb.tcc.amazbook.amazbook.modules.category.model.Category;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CategoryResponse {

    private Integer id;
    private String nameCategory;

    public static CategoryResponse of(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        BeanUtils.copyProperties(category, categoryResponse);
        return categoryResponse;
    }
}
