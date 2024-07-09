package dev.brunow.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.brunow.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	

}
