package com.practice.jwt_angular_project.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeRestController {
	@GetMapping("/all")
	public String allowAll() {
		return "Permit All Data!";
	}

	@GetMapping("/user")
	public String userData() {
		return "User Data!";
	}

	@GetMapping("/mod")
	public String moderatorData() {
		return "Moderator Data!";
	}

	@GetMapping("/admin")
//	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String adminData() {
		return "Admin Data!";
	}
}
