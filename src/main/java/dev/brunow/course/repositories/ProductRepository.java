package dev.brunow.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.brunow.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
