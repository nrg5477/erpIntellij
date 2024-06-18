package com.example.erp.category.api;

import com.example.erp.category.domain.dto.CategoryRequestDTO;
import com.example.erp.category.domain.dto.CategoryResponseDTO;
import com.example.erp.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//API패키지의 모든 컨트롤러는 RestController
//JSON을 리턴하는 메소드
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
//로그기록
@Slf4j
public class CategoryAPIController {
    private final CategoryService categoryService;

    //카테고리를 추가하기 위한 데이터를 JSON으로 입력 받고 싶은 경우
    //JSON으로 입력데이트를 만들어서 요청하면 스프링이 DTO로 변환
    //작업이 완료되면 성공완료됐는지만 넘기기
    //@RequestBody ----------- Json 데이터를 dto로 변환해서 매개변수에 전달
    //@ResponseBody --------- 자바 객체를 Json데이터로 변환해서 응답
    @PostMapping("/category/insert")
    public ResponseEntity<?> insert(@RequestBody CategoryRequestDTO inputdata) {
        System.out.println(inputdata);
        categoryService.write(inputdata);
        //ResponseEntity는 상태코드와 응답데이터의 본문을 설정
        // 성공응답을 200 응답코드를 생성하고 별도의 본문없이 응답을 반환 - ok 메시지
//        return ResponseEntity.ok().build();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public CategoryResponseDTO read(@PathVariable("categoryId") String categoryId) {
        return categoryService.findById(Long.parseLong(categoryId));
    }
}
