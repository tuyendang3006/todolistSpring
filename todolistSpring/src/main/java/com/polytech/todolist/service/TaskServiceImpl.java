package com.polytech.todolist.service;

import java.util.List;

import com.polytech.todolist.models.Task;
import com.polytech.todolist.repository.TaskRepository;

public class TaskServiceImpl implements TaskService{
	
	private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
	public List<Task> fetchAll(String username) {
		return taskRepository.fetchAll(username);
	}

	public List<Task> addTask(Task task) {
		return taskRepository.addTask(task);
		
	}

	public List<Task> deleteTask(Long id,String username) {
		return taskRepository.deleteTask(id,username);
		
	}

	public List<Task> updateDone(Task task) {
		
		return taskRepository.updateDone(task);
	}
	public List<Task> updateTask(Task task) {
		
		return taskRepository.updateTask(task);
	}
	

}
