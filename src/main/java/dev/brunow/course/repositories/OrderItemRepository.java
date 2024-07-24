package dev.brunow.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.brunow.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
