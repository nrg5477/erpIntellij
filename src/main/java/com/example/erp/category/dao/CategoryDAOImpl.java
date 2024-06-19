package com.example.erp.category.dao;

import com.example.erp.category.domain.entity.CategoryEntity;
import com.example.erp.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public List<CategoryEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public List<CategoryEntity> pagingFindAll() {
        //페이징 처리
        //1. pageable객체만들기
        //2. repository의 페이징 메소드 호출
        //3. 리턴되는 Page객체에서 List에 저장된 Entity추출하기

        //셋팅해야 하는 값들을 매개변수로 전달받아서 셋팅 - pageNumber
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "categoryId"));
        Page<CategoryEntity> page = repository.findAll(pageRequest);
        System.out.println("============================================");
        System.out.println("전체 레코드수=>" + page.getTotalElements());
        System.out.println("페이지수=>" + page.getTotalPages());
        System.out.println("조회한 레코드 수=>" + page.getNumberOfElements());
        System.out.println("한페이지 사이즈=>" + page.getSize());
        System.out.println("============================================");
        return page.getContent();
    }

    @Override
    public CategoryEntity findById(long categoryId) {
        return repository.findById(categoryId);
    }
}
