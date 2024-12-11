package com.interns.service;

import com.interns.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task saveTask(Task task);

    Task updateTask(Integer id, Task task);

    void deleteTask(Integer id);

    Optional<Task> getTaskById(Integer id);

    List<Task> getAllTasks();
}
