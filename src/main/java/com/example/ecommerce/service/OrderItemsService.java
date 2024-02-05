package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.OrderItems;
import com.example.ecommerce.repository.OrderItemsRepository;

@Service
public class OrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemsRepository;

    public List<OrderItems> getAllOrderItems() {
        return orderItemsRepository.findAll();
    }

    public OrderItems getOrderItemById(Long orderItemId) {
        return orderItemsRepository.findById(orderItemId).orElse(null);
    }

    public OrderItems createOrderItem(OrderItems orderItem) {
        return orderItemsRepository.save(orderItem);
    }

    public OrderItems updateOrderItem(Long orderItemId, OrderItems updatedOrderItem) {
        OrderItems existingOrderItem = orderItemsRepository.findById(orderItemId).orElse(null);

        if (existingOrderItem != null) {
            // Update fields if not null
            if (updatedOrderItem.getQuantity() != null) {
                existingOrderItem.setQuantity(updatedOrderItem.getQuantity());
            }
            if (updatedOrderItem.getUnitPrice() != null) {
                existingOrderItem.setUnitPrice(updatedOrderItem.getUnitPrice());
            }


            // Save the updated order item
            return orderItemsRepository.save(existingOrderItem);
        } else {
            // Order item not found
            return null;
        }
    }

    public void deleteOrderItem(Long orderItemId) {
        orderItemsRepository.deleteById(orderItemId);
    }
}


