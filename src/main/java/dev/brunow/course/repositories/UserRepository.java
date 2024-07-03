package dev.brunow.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.brunow.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
