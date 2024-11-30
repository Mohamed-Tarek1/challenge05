package com.banquemisr.challenge05.repository;

import com.banquemisr.challenge05.dto.TaskDto;
import com.banquemisr.challenge05.enttiy.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value = "SELECT * " +
            "FROM tasks t WHERE t.id = :id", nativeQuery = true)
    Task findTaskById(@Param("id") Long id);

    @Query(value = "SELECT * " +
            "FROM tasks t WHERE t.title = :name order by t.due_date desc limit 1 ", nativeQuery = true)
    Task findTaskByName(@Param("name") String name);

    @Query(value = "SELECT t.id, t.title, t.description, t.status, t.priority, t.due_date, t.user_id " +
            "FROM tasks t WHERE t.title = :name AND t.description = :description order by t.due_date desc limit 1", nativeQuery = true)
    Task findTaskByNameAndDescription(@Param("name") String name, @Param("description") String description);

    @Query(value = "SELECT * " +
            "FROM tasks t WHERE t.status = :status order by t.due_date desc", nativeQuery = true)
    ArrayList<Task> findTasksByStatus(@Param("status") String status);

    @Query(value = "SELECT t.id, t.title, t.description, t.status, t.priority, t.due_date, t.user_id " +
            "FROM tasks t WHERE t.due_date = :dueDate order by t.due_date desc", nativeQuery = true)
    ArrayList<Task> findTaskByDueDate(@Param("dueDate") LocalDate localDate);
}

