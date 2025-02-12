package com.hargovind.grocery_booking_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hargovind.grocery_booking_api.entity.GroceryItem;
import com.hargovind.grocery_booking_api.service.GroceryItemService;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/admin/items")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    @Autowired
    private GroceryItemService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GroceryItem addItem(@RequestBody GroceryItem item) {
        return service.addItem(item);
    }

    @GetMapping
    public List<GroceryItem> getAllItems() {
        return service.getAllItems();
    }

    @PutMapping("/{id}")
    public GroceryItem updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return service.updateItem(id, item);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
    }
}