package com.hargovind.grocery_booking_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hargovind.grocery_booking_api.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}