package com.feuji.taskmanager.service;

import java.util.List;

import com.feuji.taskmanager.payload.TaskDto;

public interface TaskService {

	
	public List<TaskDto> getAllTasks(long userId);

	TaskDto saveTask(long userId, TaskDto dto);
	
	public TaskDto gettask(long userId, long taskId);

	public void deleteTask(long userId ,long taskId);
}
