package com.feuji.taskmanager.serviceimplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.feuji.taskmanager.entity.Users;
import com.feuji.taskmanager.payload.UserDto;
import com.feuji.taskmanager.repository.UserRepository;
import com.feuji.taskmanager.service.UsersService;

@Service
public class UserServiceImplementation implements UsersService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public UserDto adduser(UserDto dto) {
		dto.setPassword(encoder.encode(dto.getPassword()));
		Users users = mapper.map(dto, Users.class);
		Users savedUser = repository.save(users);
		return mapper.map(savedUser, UserDto.class);
	}

}
