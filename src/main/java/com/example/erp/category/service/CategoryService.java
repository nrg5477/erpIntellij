package com.example.erp.category.service;


import com.example.erp.category.domain.dto.CategoryRequestDTO;
import com.example.erp.category.domain.dto.CategoryResponseDTO;

import java.util.List;

public interface CategoryService {
    void write(CategoryRequestDTO category);
    List<CategoryResponseDTO> findAll();
    List<CategoryResponseDTO> pagingFindAll();
    CategoryResponseDTO findById(long categoryId);
}
