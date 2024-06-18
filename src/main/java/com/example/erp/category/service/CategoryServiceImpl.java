package com.example.erp.category.service;

import com.example.erp.category.dao.CategoryDAO;
import com.example.erp.category.domain.dto.CategoryRequestDTO;
import com.example.erp.category.domain.dto.CategoryResponseDTO;
import com.example.erp.category.domain.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    //컨트롤러에는 DTO로 , dao에는 엔티티로 작업해야함.

    private final CategoryDAO dao;
    @Override
    public void write(CategoryRequestDTO category) {
        //컨트롤러에서 넘겨받은 CategoryRequestDTO를 Entity로 변환해서 넘기기
        //step 1 - 생성자를 이용해서 직접 변경
        CategoryEntity entity = new CategoryEntity(category.getCategoryName(), category.getInfo());
        dao.write(entity);
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
        return List.of();
    }

    @Override
    public List<CategoryResponseDTO> pagingFindAll() {
        return List.of();
    }

    @Override
    public CategoryResponseDTO findById(long categoryId) {
        CategoryEntity entity = dao.findById(categoryId);
        return CategoryResponseDTO.builder().categoryId(entity.getCategoryId()).categoryName(entity.getCategoryName()).info(entity.getInfo()).build();
    }
}
