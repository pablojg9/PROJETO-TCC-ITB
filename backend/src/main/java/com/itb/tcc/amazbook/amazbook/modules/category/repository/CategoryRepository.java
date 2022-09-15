package com.itb.tcc.amazbook.amazbook.modules.category.repository;

import com.itb.tcc.amazbook.amazbook.modules.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByNameCategoryContainingIgnoreCase(String name);
}
