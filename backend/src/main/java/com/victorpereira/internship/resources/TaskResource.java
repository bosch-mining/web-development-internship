package com.victorpereira.internship.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.victorpereira.internship.models.Task;
import com.victorpereira.internship.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
@CrossOrigin(origins = "*")
public class TaskResource {
	
	@Autowired
	private TaskService service;
	
	@GetMapping
	public List<Task> listTasks() {
		return service.listTasks();
	}
	
	@GetMapping(value="/{taskId}")
	public Task getTask(@PathVariable Integer taskId) {
		return service.getTask(taskId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createTask(@RequestBody Task task) {
		service.createTask(task);
	}
	
	@PutMapping(value="/{taskId}")
	public void editTask(@PathVariable Integer taskId, @RequestBody Task task) {
		service.editTask(taskId, task);
	}
	
	@DeleteMapping(value="/{taskId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTask(@PathVariable Integer taskId) {
		service.deleteTask(taskId);
	}
}
