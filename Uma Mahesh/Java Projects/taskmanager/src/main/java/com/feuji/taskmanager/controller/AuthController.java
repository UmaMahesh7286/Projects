package com.feuji.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.taskmanager.payload.JwtAuthResponse;
import com.feuji.taskmanager.payload.LoginDto;
import com.feuji.taskmanager.payload.UserDto;
import com.feuji.taskmanager.security.JwtTokenProvider;
import com.feuji.taskmanager.service.UsersService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private UsersService service;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;
//	Store the data in database

	@PostMapping("/register")
	public ResponseEntity<UserDto> createuser(@RequestBody UserDto dto) {
		return new ResponseEntity<>(service.adduser(dto), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> loginuser(@RequestBody LoginDto dto) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = jwtTokenProvider.generatetoken(authentication);
		return ResponseEntity.ok(new JwtAuthResponse(token));
	}
	
	
}
