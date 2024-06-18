package com.example.erp.category.dao;

import com.example.erp.category.domain.entity.CategoryEntity;
import com.example.erp.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryDAOImpl implements CategoryDAO {

    private final CategoryRepository repository;

    @Override
    public void write(CategoryEntity category) {
        repository.save(category);
    }

    @Override
    public List<com.example.erp.category.domain.entity.CategoryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<com.example.erp.category.domain.entity.CategoryEntity> pagingFindAll() {
        return List.of();
    }

    @Override
    public CategoryEntity findById(long categoryId) {
        return repository.findById(categoryId);
    }
}
