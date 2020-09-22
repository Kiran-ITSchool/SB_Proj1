package com.kiranit.rest.mappers;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kiranit.rest.dtos.UserMsDtos;
import com.kiranit.rest.entities.User;

@Configuration
@Mapper(componentModel="Spring")
public interface UserMapper {

	
	
	UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);
	
	// User toUserMSDto
	
	@Mappings({@Mapping(source="email",target="emailaddress"),
	@Mapping(source="role",target="rolename")})
	UserMsDtos UsertoUserDto(User user);
	
	// List<User> to List<UserMsDto>
	
	List<UserMsDtos> UsertoUserDtos(List<User> users);
	
}
