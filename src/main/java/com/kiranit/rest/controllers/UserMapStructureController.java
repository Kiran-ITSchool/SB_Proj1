package com.kiranit.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiranit.rest.dtos.UserMsDtos;
import com.kiranit.rest.entities.User;
import com.kiranit.rest.mappers.UserMapper;
import com.kiranit.rest.repositories.UserRepository;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructureController {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired(required=false)
	private UserMapper userMapper;
	
	
	@GetMapping
    public List<UserMsDtos> getAllUsersDtos()
    {
		return userMapper.UsertoUserDtos(userRepository.findAll());
    }
	
	
	// GetUserById using mapStruct
	
	@GetMapping("/{id}")
	public UserMsDtos getUserById(@PathVariable long id)
	{
		Optional<User> optionaluser=userRepository.findById(id);
		
		User theuser=optionaluser.get();
		return userMapper.UsertoUserDto(theuser);
	}
}
