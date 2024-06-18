package com.example.erp.category.domain.entity;

import com.example.erp.category.domain.entity.OrderProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
//주문일반
public class OrderEntity {
    private Long orderId;
    private Date orderDate;//주문한시간
    private String addr; //배송주소
    private String customerId;
    //주문일반1에 대해서 구매한 정보(orderDetail)
     private List<OrderProductEntity> orderproductlist = new ArrayList<>();


}











