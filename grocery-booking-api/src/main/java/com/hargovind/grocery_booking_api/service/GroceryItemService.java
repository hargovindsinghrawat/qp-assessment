package com.hargovind.grocery_booking_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hargovind.grocery_booking_api.entity.GroceryItem;
import com.hargovind.grocery_booking_api.repository.GroceryItemRepository;

@Service
public class GroceryItemService {
    @Autowired
    private GroceryItemRepository repository;

    public GroceryItem addItem(GroceryItem item) {
        return repository.save(item);
    }

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public GroceryItem updateItem(Long id, GroceryItem item) {
        GroceryItem existing = repository.findById(id).orElseThrow();
        existing.setName(item.getName());
        existing.setPrice(item.getPrice());
        existing.setInventory(item.getInventory());
        return repository.save(existing);
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}