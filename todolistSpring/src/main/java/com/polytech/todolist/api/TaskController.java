package com.polytech.todolist.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.polytech.todolist.models.Task;
import com.polytech.todolist.service.TaskService;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TaskController {
	@Autowired
    TaskService taskService;
	
	@GetMapping("/getTaskSet")
    public List<Task> getTaskSet(Principal p) {
        String username=p.getName();
        return taskService.fetchAll(username);
    }
	
	
    @PostMapping("/addTask")
    public List<Task> addTask(@RequestBody String content,Principal p) {
    	String username=p.getName();
        return taskService.addTask(new Task(content,username));
    }
    
    @PostMapping("/deleteTask")
    public List<Task> deleteTask(@RequestBody Long id,Principal p) {
    	
        return taskService.deleteTask(id,p.getName());
    }

    @PostMapping("/updateDone")
    public List<Task> updateDone(@RequestBody Task task) {
    	
        return taskService.updateDone(new Task(task.getId(),task.getContent(),!task.isDone(),task.getUsername()));
    }
    
    @PostMapping("/updateTask")
    public List<Task> updateTask(@RequestBody Task task, Principal p) {
    	
        return taskService.updateTask(new Task(task.getId(),task.getContent(),p.getName()));
    }
    
}
