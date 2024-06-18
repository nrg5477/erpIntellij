package com.example.erp.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.erp.category.domain.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

//Repository 인터페이스는 내부적으로 구현체를 스프링프레임워크에서 제공하므로 이 자체가 DAO의 역할을 할 수 있다.
//서비스 단에서 repository를 직접 호출해서 사용할수 있다.
//규모가 큰 프로젝트 같은 경우 view -> controller -> service -> dao -> repository  순서로 호출
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
