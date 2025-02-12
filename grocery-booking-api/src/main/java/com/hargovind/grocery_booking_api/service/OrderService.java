package com.hargovind.grocery_booking_api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hargovind.grocery_booking_api.dto.OrderItemRequest;
import com.hargovind.grocery_booking_api.dto.OrderRequest;
import com.hargovind.grocery_booking_api.entity.GroceryItem;
import com.hargovind.grocery_booking_api.entity.Order;
import com.hargovind.grocery_booking_api.entity.OrderItem;
import com.hargovind.grocery_booking_api.repository.GroceryItemRepository;
import com.hargovind.grocery_booking_api.repository.OrderItemRepository;
import com.hargovind.grocery_booking_api.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private GroceryItemRepository groceryItemRepo;

    public Order createOrder(OrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setCreatedAt(LocalDateTime.now());
        Order savedOrder = orderRepo.save(order);

        // Process items
        for (OrderItemRequest itemReq : request.getItems()) {
            GroceryItem groceryItem = groceryItemRepo.findById(itemReq.getGroceryItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(savedOrder.getId());
            orderItem.setGroceryItemId(groceryItem.getId());
            orderItem.setQuantity(itemReq.getQuantity());
            orderItem.setPrice(groceryItem.getPrice());
            orderItemRepo.save(orderItem);

            // Update inventory
            groceryItem.setInventory(groceryItem.getInventory() - itemReq.getQuantity());
            groceryItemRepo.save(groceryItem);
        }

        return savedOrder;
    }
}