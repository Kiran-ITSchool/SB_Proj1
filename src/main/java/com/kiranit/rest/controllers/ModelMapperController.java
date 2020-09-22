package com.kiranit.rest.controllers;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiranit.rest.dtos.UserMmDTO;
import com.kiranit.rest.entities.User;
import com.kiranit.rest.exceptions.UserNotFoundException;
import com.kiranit.rest.services.UserService;


@RestController
@RequestMapping("/modelmapper/users")
public class ModelMapperController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelmapper;
	
	@GetMapping("/{id}")
	public UserMmDTO getUserById(@PathVariable("id") @Min(1)Long id) throws UserNotFoundException
	{
		Optional<User> theoptional= userService.getUserById(id);
		
		if(!theoptional.isPresent())
		{
			throw new UserNotFoundException("user not found");
		}
		User theuser=theoptional.get();
		
		UserMmDTO usermmdto=modelmapper.map(theuser,UserMmDTO.class);
		return usermmdto;
	}
	
}
