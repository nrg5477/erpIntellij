package com.example.erp.category.dao;


import com.example.erp.category.domain.entity.OrderProductEntity;

import java.util.List;

public interface OrderProductDAO {
    //주문상품등록
    void save(List<OrderProductEntity> orderproductlist);
}
