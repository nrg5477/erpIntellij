package com.example.erp.category.domain.entity;

import com.example.erp.category.domain.entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProductEntity {
    private Long orderDetailId;
    private Long productNo;
    private OrderEntity myorder;
    private int orderPrice;//구매가격
    private int count;//주문수량

}









