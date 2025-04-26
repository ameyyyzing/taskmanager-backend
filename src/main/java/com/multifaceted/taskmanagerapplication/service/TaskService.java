package com.multifaceted.taskmanagerapplication.service;

import com.multifaceted.taskmanagerapplication.model.Task;
import com.multifaceted.taskmanagerapplication.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public void deleteTask(String id) {
        repository.deleteById(id);
    }
}

