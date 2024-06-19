package com.example.erp.category.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue
    private Long categoryId;
    private String categoryName;
    private String info;

    public CategoryEntity(String categoryName, String info) {
        this.categoryName = categoryName;
        this.info = info;
    }


}










