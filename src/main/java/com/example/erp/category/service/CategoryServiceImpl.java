package com.example.erp.category.service;

import com.example.erp.category.dao.CategoryDAO;
import com.example.erp.category.domain.dto.CategoryRequestDTO;
import com.example.erp.category.domain.dto.CategoryResponseDTO;
import com.example.erp.category.domain.entity.CategoryEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        List<CategoryEntity> entityList = dao.findAll();
        //엔티티를 뷰로 넘기면 안됨
        //step 3 스트림으로 변환해서 작업
        List<CategoryResponseDTO> responseList = entityList.stream()
                .map(CategoryResponseDTO::new)
                .collect(Collectors.toList());
        // 스트림으로 변환 -> 데이터 가공(map 메소드활용) -> 변환된 요소를 새로운 리스트로 모으는 작업
        return responseList;
    }

    @Override
    public List<CategoryResponseDTO> pagingFindAll() {
        //dao의 메소드를 호출하고 데이터를 변환
        List<CategoryEntity> entityList = dao.pagingFindAll();
        //step 4. 스트림으로 변환(ModelMapper을 이용)
        ModelMapper modelMapper = new ModelMapper();
        List<CategoryResponseDTO> responseList = entityList.stream()
                .map(entity -> modelMapper.map(entity, CategoryResponseDTO.class))
                .collect(Collectors.toList());
        return responseList;
    }

    @Override
    public CategoryResponseDTO findById(long categoryId) {
        CategoryEntity entity = dao.findById(categoryId);
        return CategoryResponseDTO.builder()
                .categoryId(entity.getCategoryId())
                .categoryName(entity.getCategoryName()).info(entity.getInfo()).build();
    }
}
