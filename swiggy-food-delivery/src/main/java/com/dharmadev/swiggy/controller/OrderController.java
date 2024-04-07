package com.dharmadev.swiggy.controller;

import com.dharmadev.swiggy.model.OrderEntity;
import com.dharmadev.swiggy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderEntity> addOrder(@RequestBody OrderEntity order) {
        OrderEntity addedOrder = orderService.addOrder(order);
        return new ResponseEntity<>(addedOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderEntity> getOrder(@PathVariable int orderId) {
        OrderEntity order = orderService.getOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable int orderId, @RequestParam String statusStr) {
        OrderEntity updatedOrder = orderService.updateOrder(orderId, statusStr);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<OrderEntity> deleteOrder(@PathVariable int orderId) {
        OrderEntity deletedOrder = orderService.deleteOrder(orderId);
        return new ResponseEntity<>(deletedOrder, HttpStatus.OK);
    }
}
