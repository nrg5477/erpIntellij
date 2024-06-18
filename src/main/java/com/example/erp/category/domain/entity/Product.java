package com.example.erp.category.domain.entity;

import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long productNo;
    private String productName;
    private String info;
    private int price;
    private String image;
    private Integer stock;//재고량
    private LocalDateTime insertTime;
    private Category category;


}
