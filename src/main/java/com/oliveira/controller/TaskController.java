package com.oliveira.controller;

import com.oliveira.model.Task;
import com.oliveira.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.findAllTasks();
    }

    @GetMapping("/{taskId}")
    public Task getTask(@PathVariable String taskId) {
        return taskService.getTaskByTaskId(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTasksUsingSeverity(@PathVariable int severity) {
        return taskService.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(String assignee) {
        return taskService.getTaskByAssignee(assignee);
    }

    @PutMapping
    public Task modifyTask(Task task) {
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(String taskId) {
        return taskService.deleteTask(taskId);
    }

}
