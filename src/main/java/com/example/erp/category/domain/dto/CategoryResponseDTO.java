package com.example.erp.category.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CategoryResponseDTO {
    private Long categoryId;
    private String categoryName;
    private String info;

    public CategoryResponseDTO(com.example.erp.category.domain.entity.CategoryEntity categoryEntity) {
        this.categoryId = categoryEntity.getCategoryId();
        this.categoryName = categoryEntity.getCategoryName();
        this.info = categoryEntity.getInfo();
    }
}
