package com.hargovind.grocery_booking_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class OrderItemRequest {
    @NotNull
    private Long groceryItemId;
    
    @Min(1)
    private int quantity;

	public Long getGroceryItemId() {
		return groceryItemId;
	}

	public void setGroceryItemId(Long groceryItemId) {
		this.groceryItemId = groceryItemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}