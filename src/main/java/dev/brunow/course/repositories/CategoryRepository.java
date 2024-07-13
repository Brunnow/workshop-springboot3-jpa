package dev.brunow.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.brunow.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	

}
