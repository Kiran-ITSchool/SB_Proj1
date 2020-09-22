package com.kiranit.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kiranit.rest.entities.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	// GetUser By Username
	
	User findByUsername(String username);

}
