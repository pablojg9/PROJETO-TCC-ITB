package com.itb.tcc.amazbook.amazbook.modules.category.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoryRequest {

    @JsonProperty("name_category")
    private String nameCategory;
}
