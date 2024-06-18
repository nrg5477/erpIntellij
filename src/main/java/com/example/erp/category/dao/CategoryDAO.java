package com.example.erp.category.dao;

import com.example.erp.category.domain.entity.CategoryEntity;

import java.util.List;

public interface CategoryDAO {
    void write(CategoryEntity category);
    List<CategoryEntity> findAll();
    List<CategoryEntity> pagingFindAll();
    CategoryEntity findById(long categoryId);
}
