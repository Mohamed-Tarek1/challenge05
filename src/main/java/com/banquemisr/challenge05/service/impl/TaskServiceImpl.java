package com.banquemisr.challenge05.service.impl;


import com.banquemisr.challenge05.dto.TaskDto;
import com.banquemisr.challenge05.enttiy.Status;
import com.banquemisr.challenge05.enttiy.Task;
import com.banquemisr.challenge05.mapper.TaskMapper;
import com.banquemisr.challenge05.repository.TaskRepository;
import com.banquemisr.challenge05.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        task = taskRepository.save(task);
        return taskMapper.toDto(task);
    }


    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(Long id, TaskDto taskDto) {
        Task task = new Task();
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()) {
            task= taskOptional.get();
            task.setTitle(taskDto.getTitle());
            task.setDescription(taskDto.getDescription());
            task.setStatus(Status.valueOf(taskDto.getStatus()));
            task.setDueDate(taskDto.getDueDate());
            task = taskRepository.save(task);

        } else {
            task.setDescription("Task not found");

        }
        return taskMapper.toDto(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDto findTaskById(Long id) {

        Task task = taskRepository.findTaskById(id);

             return taskMapper.toDto(task);
    }

    @Override
    public TaskDto findTaskByName(String name) {
        Task task = taskRepository.findTaskByName(name);

        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto findTaskByNameAndDescription(String name, String description) {

        Task task = taskRepository.findTaskByNameAndDescription(name, description);


        return taskMapper.toDto(task);
    }

    @Override
    public ArrayList<TaskDto> findTasksByStatus(String status) {
        ArrayList<Task> tasks = taskRepository.findTasksByStatus(status);

        ArrayList<TaskDto> taskDtos = taskMapper.toDtoArrayList(tasks);

    return  taskDtos;
    }

    @Override
    public List<TaskDto> finTaskByDueDate(LocalDate localDate) {
        ArrayList<Task> tasks = taskRepository.findTaskByDueDate(localDate);

        ArrayList<TaskDto> taskDtos = taskMapper.toDtoArrayList(tasks);

        return  taskDtos;
    }
}
