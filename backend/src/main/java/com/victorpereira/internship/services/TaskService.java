package com.victorpereira.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.victorpereira.internship.models.Task;
import com.victorpereira.internship.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repo;
	
	public List<Task> listTasks(){
		return repo.findAll();
	}
	
	public Task getTask(Integer taskId) {
		return repo.findById(taskId).orElseThrow();
	}
	
	public void createTask(Task task) {
		repo.save(task);
	}
	
	public void editTask(Integer taskId, Task task ) {
		Task tk = getTask(taskId);
		
		tk.setDescription(task.getDescription());
		tk.setState(task.getState());
		
		repo.save(tk);
	}
	
	public void deleteTask(Integer taskId) {
		repo.delete(getTask(taskId));
	}
}
