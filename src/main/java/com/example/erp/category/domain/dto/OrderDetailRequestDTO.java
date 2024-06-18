package com.example.erp.category.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailRequestDTO {
    private Long productNo;
    private int orderPrice;//구매가격
    private int count;//주문수량
}
