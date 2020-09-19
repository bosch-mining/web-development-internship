package br.com.list.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;


public class ListTask {
	
private List<Task> tasks= new ArrayList<Task>();

private long id;

public ListTask para(long id) {
	this.id = id;
	return this;
}

public long getId() {
	return id;
}
public ListTask setId(long id) {
	this.id = id;
	return this;
}


public ListTask adiciona(Task task) {
	return adiciona(task);
}


public void remove(long TaskId) {
for (Iterator iterator = tasks.iterator(); iterator.hasNext();) {
Task task= (Task) iterator.next();
if(task.getId() == task.getId()) {
return;
			}
		}
}


public String toXML() {
	return new XStream().toXML(this);
	
	}


public void troca(Task task) {
	remove(task.getId());
	adiciona(task);
}
public List<Task> getTasks() {
	return tasks;
}

}
