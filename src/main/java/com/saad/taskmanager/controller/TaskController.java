package com.saad.taskmanager.controller;

import com.saad.taskmanager.model.Task;
import com.saad.taskmanager.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173")
public class TaskController {

    @Autowired
    TaskRepo taskRepo;

    @PostMapping("/addTask")
    public Task addTask(@RequestBody Task addTask) {
        return taskRepo.save(addTask);
    }

    @GetMapping("/showTasks")
    public List<Task> showTasks() {
        return taskRepo.findAll();
    }

    @GetMapping("/showTasks/{id}")
    public Task showOneTask(@PathVariable UUID id) {
        return taskRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Invalid Id..."));
    }

    @PutMapping("/updateTask/{id}")
    public Task updateTask(@RequestBody Task tasks, @PathVariable UUID id) {
        return taskRepo.findById(id)
                .map(task -> {
                    task.setTitle(tasks.getTitle());
                    task.setDescription(tasks.getDescription());
                    return taskRepo.save(task);
                })
                .orElseThrow(()-> new RuntimeException("Could not be updated..."));
    }

    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable UUID id) {
        taskRepo.deleteById(id);
        return "User deleted successfully with ID: "+ id;
    }

}
