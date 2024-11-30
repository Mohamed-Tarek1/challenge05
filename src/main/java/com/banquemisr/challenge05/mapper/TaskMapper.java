package com.banquemisr.challenge05.mapper;


import com.banquemisr.challenge05.dto.TaskDto;
import com.banquemisr.challenge05.enttiy.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);

    ArrayList<TaskDto> toDtoArrayList(ArrayList<Task> tasks);

    @Mapping(target = "user" , ignore = true)
    Task toEntity(TaskDto taskDto);
}
