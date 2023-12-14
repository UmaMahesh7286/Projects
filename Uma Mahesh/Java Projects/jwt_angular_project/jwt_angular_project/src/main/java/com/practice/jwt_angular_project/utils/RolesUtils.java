package com.practice.jwt_angular_project.utils;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.jwt_angular_project.model.ERole;
import com.practice.jwt_angular_project.model.Role;
import com.practice.jwt_angular_project.repo.RoleRepository;

@Component
public class RolesUtils {
	@Autowired
	private RoleRepository repository;

	public Set<Role> mapRoles(Set<String> userRoles, Set<Role> dbRoles) {
		if (userRoles == null || userRoles.isEmpty()) {
			Role userRole = repository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
			dbRoles.add(userRole);
		} else {
			userRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = repository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					dbRoles.add(adminRole);
					break;
				case "mod":
					Role modRole = repository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					dbRoles.add(modRole);
					break;
				default:
					Role userRole = repository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found"));
					dbRoles.add(userRole);

					break;
				}
			});
	
		}
		return dbRoles;
	}
	
}