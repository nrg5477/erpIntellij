package com.example.erp.category.controller;

import com.example.erp.category.domain.dto.CategoryRequestDTO;
import com.example.erp.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 뷰를 렌더링하는 컨트롤러
@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    //page 보기
    @GetMapping("/write")
    public String showPage() {
        return "manage/product/category";
    }

    @PostMapping("/write")
    public String showPage(CategoryRequestDTO inputdto) {
        System.out.println(inputdto);
        categoryService.write(inputdto);
        return "manage/product/category";
    }
}
