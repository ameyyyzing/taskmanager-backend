package com.multifaceted.taskmanagerapplication.repository;

import com.multifaceted.taskmanagerapplication.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {
}
