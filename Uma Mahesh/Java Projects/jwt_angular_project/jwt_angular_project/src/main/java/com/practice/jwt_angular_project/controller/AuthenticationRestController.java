package com.practice.jwt_angular_project.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.jwt_angular_project.model.Role;
import com.practice.jwt_angular_project.model.User;
import com.practice.jwt_angular_project.model.UserDetailsImpl;
import com.practice.jwt_angular_project.repo.UserRepository;
import com.practice.jwt_angular_project.request.LoginRequest;
import com.practice.jwt_angular_project.request.SignupRequest;
import com.practice.jwt_angular_project.response.JwtResponse;
import com.practice.jwt_angular_project.response.MessageResponse;
import com.practice.jwt_angular_project.utils.JwtUtils;
import com.practice.jwt_angular_project.utils.RolesUtils;

@RestController
@RequestMapping("/auth")
public class AuthenticationRestController {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RolesUtils rolesUtils;
	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtUtils.generateToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
				userDetails.getEmail(),
				userDetails.getAuthorities().stream().map(auth -> auth.getAuthority()).collect(Collectors.toSet())

		));
	}

	@PostMapping("/register")
	public ResponseEntity<?> createUser(@Valid @RequestBody SignupRequest signupRequest) {

		if (userRepository.existsByUsername(signupRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error : Username already exist"));
		}

		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error : EmailId already exist"));
		}
		User user = new User(signupRequest.getUsername(), signupRequest.getEmail(),
				encoder.encode(signupRequest.getPassword()));

		Set<String> usrRoles = signupRequest.getRole();

		Set<Role> dbRoles = new HashSet<>();

		dbRoles = rolesUtils.mapRoles(usrRoles, dbRoles);

		user.setRoles(dbRoles);
		userRepository.save(user);
		return ResponseEntity.ok(new MessageResponse("User Created Successfully!"));
	}

}
