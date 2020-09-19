package br.com.list.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


public class Task {
	private long id;
	private String description ;
	private  String TaskState;
	
	Task() {
	}
	
	public Task(long id, String description,String TaskState) {
		this.id = id;
		this.description = description;
		this.TaskState = TaskState;
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getTaskState() {
		return TaskState;
	}
	public void setTaskState(String taskState) {
		TaskState = taskState;
	}

}
