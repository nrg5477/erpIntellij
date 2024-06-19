package com.example.erp.category.dao;

import com.example.erp.category.domain.entity.CategoryEntity;
import com.example.erp.category.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
@Transactional
@Rollback(value = false)
class CategoryDAOImplTest {

    @Autowired
    CategoryRepository repository;

    @Test
    public void test1() {
        CategoryEntity category1 = new CategoryEntity("셔츠","블라우스포함");
        CategoryEntity category2 = new CategoryEntity("가방","자체제작");
        CategoryEntity category3 = new CategoryEntity("팬츠","반바지포함");
        CategoryEntity category4 = new CategoryEntity("악세사리","목걸이, 리본포함");
        //한번에 insert
        repository.saveAll(Lists.newArrayList(category1, category2, category3, category4));
    }

//    @Test
//    public void test2() {
//        //update
//        //수정할 레코드를 조회
//        CategoryEntity category = repository.findById(3L).get();
//        System.out.println(category);
//
//        //setter메소드를 호출해서 변경
//        category.setCategoryName("아우터");
//        category.setInfo("코트와 패딩있음");
//
//        //save호출
//        //save메소드는 객체를 새롭게 만들어서 작업하는 경우 insert문이 만들어지고
//        //조회된 객체의 setter메소드를 호출해서 값을 변경하는 경우에는 update문이 만들어진다.
//        repository.save(category);
//
//    }

    @Test
    public void test3() {
        List<CategoryEntity> list = repository.findByCategoryNameContaining("가");
        System.out.println(list);
    }

}