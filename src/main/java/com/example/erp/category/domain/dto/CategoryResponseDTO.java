package com.example.erp.category.domain.dto;

import com.example.erp.category.domain.entity.CategoryEntity;
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

    public CategoryResponseDTO(CategoryEntity categoryEntity) {
        this.categoryId = categoryEntity.getCategoryId();
        this.categoryName = categoryEntity.getCategoryName();
        this.info = categoryEntity.getInfo();
    }
}
