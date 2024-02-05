package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.entity.OrderItems;
import com.example.ecommerce.service.OrderItemsService;

@RestController
@RequestMapping("/orderItems")
public class OrderItemsController {

    @Autowired
    private OrderItemsService orderItemsService;

    @GetMapping
    public List<OrderItems> getAllOrderItems() {
        return orderItemsService.getAllOrderItems();
    }

    @GetMapping("/{orderItemId}")
    public OrderItems getOrderItemById(@PathVariable Long orderItemId) {
        return orderItemsService.getOrderItemById(orderItemId);
    }

    @PostMapping
    public OrderItems createOrderItem(@RequestBody OrderItems orderItem) {
        return orderItemsService.createOrderItem(orderItem);
    }

    @PutMapping("/{orderItemId}")
    public OrderItems updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItems updatedOrderItem) {
        return orderItemsService.updateOrderItem(orderItemId, updatedOrderItem);
    }

    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemsService.deleteOrderItem(orderItemId);
    }
}
