package com.banquemisr.challenge05.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Integer priority;
    private LocalDate dueDate;
    private Long userId;
}

