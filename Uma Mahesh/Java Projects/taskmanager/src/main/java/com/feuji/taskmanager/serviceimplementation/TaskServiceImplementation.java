package com.feuji.taskmanager.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feuji.taskmanager.entity.Task;
import com.feuji.taskmanager.entity.Users;
import com.feuji.taskmanager.exception.ApiException;
import com.feuji.taskmanager.exception.TaskNotFound;
import com.feuji.taskmanager.exception.UserNotFound;
import com.feuji.taskmanager.payload.TaskDto;
import com.feuji.taskmanager.repository.TaskRepository;
import com.feuji.taskmanager.repository.UserRepository;
import com.feuji.taskmanager.service.TaskService;

@Service
public class TaskServiceImplementation implements TaskService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private TaskRepository taskRepository;
	
	
	@Override
	public TaskDto saveTask(long userId, TaskDto dto) {
		Users users=repository.findById(userId).orElseThrow(
				()-> new UserNotFound(String.format("User Id %d not found", userId)));
		Task task=mapper.map(dto,Task.class);
		//after setting the user, we are storing the data in database
		task.setUsers(users);
		Task savedTask= taskRepository.save(task);
		return mapper.map(savedTask,TaskDto.class);
	}

	@Override
	public List<TaskDto> getAllTasks(long userId)  {
	repository.findById(userId).orElseThrow(
			()-> new UserNotFound(String.format("User Id %d not found", userId)));
	List<Task> tasks=taskRepository.findAllByUsersId(userId);
	return tasks.stream().map(
			task -> mapper.map(task, TaskDto.class)
			).collect(Collectors.toList());
			
	}

	@Override
	public TaskDto gettask(long userId, long taskId) {
		Users users=repository.findById(userId).orElseThrow(
				()-> new UserNotFound(String.format("User Id %d not found", userId)));
		Task task=taskRepository.findById(taskId).orElseThrow(
				()-> new TaskNotFound(String.format("Tash Id %d not found", taskId))
				);
		if(users.getId()!=task.getUsers().getId()) {
			throw new ApiException(String.format("Task id %d is not belong to User id %d", taskId,userId));
		}
		return mapper.map(task, TaskDto.class);
	}

	@Override
	public void deleteTask(long userId, long taskId) {
		Users users=repository.findById(userId).orElseThrow(
				()-> new UserNotFound(String.format("User Id %d not found", userId)));
		Task task=taskRepository.findById(taskId).orElseThrow(
				()-> new TaskNotFound(String.format("Tash Id %d not found", taskId))
				);
		if(users.getId()!=task.getUsers().getId()) {
			throw new ApiException(String.format("Task id %d is not belong to User id %d", taskId,userId));
		}
		taskRepository.deleteById(taskId);
	}

}
