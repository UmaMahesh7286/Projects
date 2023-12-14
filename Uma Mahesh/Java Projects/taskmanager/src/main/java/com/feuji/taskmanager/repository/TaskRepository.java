package com.feuji.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feuji.taskmanager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {


	List<Task> findAllByUsersId(long userId);

}
