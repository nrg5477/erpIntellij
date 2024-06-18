package com.example.erp.category.dao;


import com.example.erp.category.domain.entity.OrderEntity;

import java.util.List;

public interface OrderDAO {
    void save(OrderEntity orderEntity);
    OrderEntity findById(Long orderId);

    List<OrderEntity> getOrders(String customerId);
}
