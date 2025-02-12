package com.hargovind.grocery_booking_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hargovind.grocery_booking_api.dto.OrderRequest;
import com.hargovind.grocery_booking_api.entity.GroceryItem;
import com.hargovind.grocery_booking_api.entity.Order;
import com.hargovind.grocery_booking_api.service.GroceryItemService;
import com.hargovind.grocery_booking_api.service.OrderService;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
public class UserController {
    @Autowired
    private GroceryItemService groceryService;
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/items")
    public List<GroceryItem> getAvailableItems() {
        return groceryService.getAllItems();
    }

    @PostMapping("/orders")
    public Order createOrder(@RequestBody OrderRequest request) {
        return orderService.createOrder(request);
    }
}