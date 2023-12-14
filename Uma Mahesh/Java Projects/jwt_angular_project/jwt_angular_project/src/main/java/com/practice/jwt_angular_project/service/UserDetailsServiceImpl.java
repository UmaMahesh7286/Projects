package com.practice.jwt_angular_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.jwt_angular_project.model.User;
import com.practice.jwt_angular_project.model.UserDetailsImpl;
import com.practice.jwt_angular_project.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository repository;
	//loading model class user object
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		User user = repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("User not exist" + email));

		//converting into Spring Security User object
		return UserDetailsImpl.build(user);
	}
}
