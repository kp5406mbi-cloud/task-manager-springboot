package com.example.demo.service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exception.UnauthorizedException;


import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // CREATE TASK
    public Task createTask(Task task, String username) {
        task.setOwner(username);
        return taskRepository.save(task);
    }

    // GET ALL TASKS (only user's tasks)
    public List<Task> getUserTasks(String username) {
        return taskRepository.findByOwner(username);
    }

    // GET TASK BY ID (only if owner)
    public Task getTaskById(Long id, String username) throws UnauthorizedException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        if (!task.getOwner().equals(username)) {
            throw new UnauthorizedException("Unauthorized access");
        }

        return task;
    }

    // UPDATE TASK
    public Task updateTask(Long id, Task updatedTask, String username) throws UnauthorizedException {
        Task task = getTaskById(id, username);

        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());

        return taskRepository.save(task);
    }

    // DELETE TASK
    public void deleteTask(Long id, String username) throws UnauthorizedException {
        Task task = getTaskById(id, username);
        taskRepository.delete(task);
    }
}