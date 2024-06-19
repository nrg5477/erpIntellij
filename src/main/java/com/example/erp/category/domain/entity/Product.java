package com.example.erp.category.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private Long productNo;
    private String productName;
    private String info;
    private int price;
    private String image;
    private Integer stock;//재고량
    private LocalDateTime insertTime;
    private Category category;


}
