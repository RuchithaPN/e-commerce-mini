package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.Orders;
import com.example.ecommerce.repository.OrdersRepository;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    public Orders getOrderById(Long orderId) {
        return ordersRepository.findById(orderId).orElse(null);
    }

    public Orders createOrder(Orders order) {
        // Additional logic if needed
        return ordersRepository.save(order);
    }

    public Orders updateOrder(Long orderId, Orders updatedOrder) {
        Orders existingOrder = ordersRepository.findById(orderId).orElse(null);

        if (existingOrder != null) {
            // Update fields if not null
            if (updatedOrder.getCustomer() != null) {
                existingOrder.setCustomer(updatedOrder.getCustomer());
            }
            if (updatedOrder.getOrderDate() != null) {
                existingOrder.setOrderDate(updatedOrder.getOrderDate());
            }
            if (updatedOrder.getTotalAmount() != null) {
                existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
            }

   

            // Save the updated order
            return ordersRepository.save(existingOrder);
        } else {
            // Order not found
            return null;
        }
    }


    public void deleteOrder(Long orderId) {
        ordersRepository.deleteById(orderId);
    }
}

