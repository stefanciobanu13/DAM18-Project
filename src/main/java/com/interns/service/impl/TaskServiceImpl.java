package com.interns.service.impl;

import com.interns.model.Task;
import com.interns.model.repository.TaskRepository;
import com.interns.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Integer id, Task task) {
        return taskRepository.findById(id)
                .map(existingTask -> {
                    existingTask.setTitle(task.getTitle());
                    existingTask.setDescription(task.getDescription());
                    existingTask.setStatus(task.getStatus());
                    existingTask.setIntern(task.getIntern());
                    existingTask.setProject(task.getProject());
                    return taskRepository.save(existingTask);
                })
                .orElseThrow(() -> new IllegalArgumentException("Task with ID " + id + " not found."));
    }

    @Override
    public void deleteTask(Integer id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Task with ID " + id + " not found.");
        }
    }

    @Override
    public Optional<Task> getTaskById(Integer id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}