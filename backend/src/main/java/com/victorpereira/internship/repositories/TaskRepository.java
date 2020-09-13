package com.victorpereira.internship.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.victorpereira.internship.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
