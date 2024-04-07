package com.dharmadev.swiggy.service;

import com.dharmadev.swiggy.exception.OrderException;
import com.dharmadev.swiggy.model.OrderEntity;

public interface OrderService {
   OrderEntity addOrder(OrderEntity order) throws OrderException;
    OrderEntity getOrder(int orderId) throws OrderException;
    OrderEntity updateOrder(int orderId, String status) throws OrderException;
    OrderEntity deleteOrder(int orderId) throws OrderException;
}
