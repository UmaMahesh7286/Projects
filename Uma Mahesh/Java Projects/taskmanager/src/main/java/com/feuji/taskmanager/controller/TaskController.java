package com.feuji.taskmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feuji.taskmanager.payload.TaskDto;
import com.feuji.taskmanager.service.TaskService;

@RestController
@RequestMapping("/api/auth")
public class TaskController {

	@Autowired
	private TaskService service;

	// save the task
	@PostMapping("/{userId}/tasks")
	public ResponseEntity<TaskDto> saveTask(@PathVariable(name = "userId") long userId, @RequestBody TaskDto dto) {
		return new ResponseEntity<>(service.saveTask(userId, dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{userId}/alltasks")
	public ResponseEntity<List<TaskDto>> getAllTasks(@PathVariable(name="userId")long userId){
		return new ResponseEntity<>(service.getAllTasks(userId),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/{userId}/task/{taskId}")
	public ResponseEntity<TaskDto> getTask(
			@PathVariable(name="userId")long userId,@PathVariable(name="taskId")long taskId
			){
		return new ResponseEntity<>(service.gettask(userId, taskId),HttpStatus.OK);
	}
	
	@PreAuthorize(value="ROLE_ADMIN")
	@DeleteMapping("/{userId}/task/{taskId}")
	public ResponseEntity<String> deleteTask(
			@PathVariable(name="userId")long userId,@PathVariable(name="taskId")long taskId
			){
		service.deleteTask(userId, taskId);
		return new ResponseEntity<>("Task Deleted successfully",HttpStatus.OK);
	}
	
	
}
