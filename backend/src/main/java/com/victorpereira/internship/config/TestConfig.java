package com.victorpereira.internship.config;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.victorpereira.internship.enums.TaskState;
import com.victorpereira.internship.models.Task;
import com.victorpereira.internship.repositories.TaskRepository;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private TaskRepository repo;

	@Bean
	public boolean instatiateDatabase() throws ParseException {

		Task t1 = new Task(null, "Limpar a casa", TaskState.OPEN);
		Task t2 = new Task(null, "Aguar as plantas", TaskState.OPEN);
		Task t3 = new Task(null, "Ir ao mercado", TaskState.DONE);
		Task t4 = new Task(null, "Passear com o cachorro", TaskState.DONE);
		
		repo.saveAll(Arrays.asList(t1, t2, t3, t4));
		
		return true;
	}
}