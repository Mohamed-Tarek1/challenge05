package com.banquemisr.challenge05.controller;

import com.banquemisr.challenge05.dto.TaskDto;
import com.banquemisr.challenge05.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/createTask")
    public TaskDto createTask(@RequestBody TaskDto taskDto) {
        log.info("Creating task: {}", taskDto);
        return taskService.createTask(taskDto);
    }

    @GetMapping("/getAllTasks")
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/getByname")
    public TaskDto getTaskByName(@RequestParam String name) {
        return taskService.findTaskByName(name);
    }

    @GetMapping("/getBynameDescription")
    public TaskDto getTaskByNameAndDescription(@RequestParam String name, @RequestParam String description) {
        return taskService.findTaskByNameAndDescription(name, description);
    }

    @GetMapping("/getByStatus")
    public List<TaskDto> getTasksByStatus(@RequestParam String status) {
        return taskService.findTasksByStatus(status);
    }

    @GetMapping("/getByDate")
    public List<TaskDto> getTasksByDueDate(@RequestParam String dueDate) {
        LocalDate date = LocalDate.parse(dueDate);
        return taskService.finTaskByDueDate(date);
    }

    @PutMapping("/updateTask/{id}")
    public TaskDto updateTask(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        return taskService.updateTask(id, taskDto);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }


}

