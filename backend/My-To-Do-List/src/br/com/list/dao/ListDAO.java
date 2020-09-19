package br.com.list.dao;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.list.modelo.ListTask;
import br.com.list.modelo.Task;


public class ListDAO {
	
	private static Map<Long, ListTask> banco = new HashMap<Long, ListTask>();
	private static AtomicLong contador = new AtomicLong(1);
	


	static {
		Task videogame = new Task (6237, "Videogame 4"," teste");
		
		ListTask listTask = new ListTask().adiciona(videogame).para(1).setId(1);
		banco.put(1l, listTask);
	}


	public void adiciona(ListTask listTask) {
		long id = contador.incrementAndGet();
		listTask.setId(id);
		banco.put(id, listTask);
	}
	
	public ListTask busca(long id) {
		return banco.get(id);
	}
	
	public ListTask remove(long id) {
		return banco.remove(id);
	}

	
}

