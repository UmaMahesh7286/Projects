package com.practice.jwt_angular_project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.jwt_angular_project.model.ERole;
import com.practice.jwt_angular_project.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(ERole name);
}