package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // GET LOGGED-IN USER
    private String getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    // CREATE TASK
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task, getCurrentUser());
    }

    // GET ALL TASKS (ONLY USER'S)
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getUserTasks(getCurrentUser());
    }

    // GET TASK BY ID
    @GetMapping("/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskService.getTaskById(id, getCurrentUser());
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return taskService.updateTask(id, task, getCurrentUser());
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id, getCurrentUser());
        return "Task deleted successfully";
    }
}