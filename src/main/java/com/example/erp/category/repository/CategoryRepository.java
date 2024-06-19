package com.example.erp.category.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.erp.category.domain.entity.CategoryEntity;

import java.util.List;

//Repository 인터페이스는 내부적으로 구현체를 스프링프레임워크에서 제공하므로 이 자체가 DAO의 역할을 할 수 있다.
//서비스 단에서 repository를 직접 호출해서 사용할수 있다.
//규모가 큰 프로젝트 같은 경우 view -> controller -> service -> dao -> repository  순서로 호출
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    //@Override
    //    public CategoryEntity findById(long categoryId) {
    //        return repository.findById(categoryId);
    //    }
    CategoryEntity findById(long categoryId);

    //로그인
//    CategoryEntity findByIdAndPass(String id, String pass);

    List<CategoryEntity> findByCategoryNameContaining(String categoryName);
    List<CategoryEntity> findByCategoryNameStartingWith(String categoryName);
    Page<CategoryEntity> pageByCategoryNameContaining(String categoryName, Pageable pageable);
    Slice<CategoryEntity> findInfoStartingWith(String categoryName, Pageable pagerequest);
}
