package com.banquemisr.challenge05.service;

import com.banquemisr.challenge05.dto.TaskDto;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);

    List<TaskDto> getAllTasks();

    TaskDto updateTask(Long id, TaskDto taskDto);

    void deleteTask(Long id);

    TaskDto findTaskById(Long id);

    TaskDto findTaskByName(String name);

    TaskDto findTaskByNameAndDescription(String name, String description);

    List<TaskDto> findTasksByStatus (String status);

    List<TaskDto> finTaskByDueDate (LocalDate localDate);
}

