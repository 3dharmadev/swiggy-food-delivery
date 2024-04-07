package com.dharmadev.swiggy.service;

import com.dharmadev.swiggy.exception.DeliveryPartnerException;
import com.dharmadev.swiggy.exception.OrderException;
import com.dharmadev.swiggy.model.OrderEntity;
import com.dharmadev.swiggy.model.Status;
import com.dharmadev.swiggy.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity addOrder(OrderEntity order) throws OrderException {
        if(order==null){
            throw new OrderException("Order can not be null");
        }

        if(orderRepository.existsById(order.getOrderId())){
            throw  new OrderException("Order id "+order.getOrderId()+" already exists");
        }
        return orderRepository.save(order);
    }

    @Override
    public OrderEntity getOrder(int orderId) throws OrderException {
       Optional<OrderEntity> optional = orderRepository.findById(orderId);
       if(optional.isEmpty()){
           throw new OrderException("Order with id " + orderId + " not found");
       }
       else {
           return optional.get();
       }
     }

    @Override
    public OrderEntity updateOrder(int orderId, String statusStr) throws OrderException {
                Optional<OrderEntity> optional =  orderRepository.findById(orderId);
                if(optional.isEmpty()){
                    throw new OrderException("Order with id " + orderId + " not found");
                }

        OrderEntity order = optional.get();
        Status status = Status.valueOf(statusStr);
        order.setStatus(status);
        return orderRepository.save(order);
    }

    @Override
    public OrderEntity deleteOrder(int orderId) throws OrderException {
       Optional<OrderEntity> optional= orderRepository.findById(orderId);

       if(optional.isEmpty()){
           throw new OrderException("Order with id " + orderId + " not found");
       }
       else{
         OrderEntity order=  optional.get();
         orderRepository.deleteById(orderId);
         return order;
       }
    }
}
