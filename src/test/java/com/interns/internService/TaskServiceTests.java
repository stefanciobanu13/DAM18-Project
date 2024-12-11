package com.interns.internService;

import com.interns.model.Task;
import com.interns.model.repository.TaskRepository;
import com.interns.service.impl.TaskServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTests {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskServiceImpl taskService;

    private Task task;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        task = new Task();
        task.setId(1);
        task.setTitle("Fix Bugs");
    }

    @Test
    void testSaveTask() {
        when(taskRepository.save(task)).thenReturn(task);
        Task savedTask = taskService.saveTask(task);
        assertNotNull(savedTask);
        assertEquals("Fix Bugs", savedTask.getTitle());
    }

    @Test
    void testGetTaskById() {
        when(taskRepository.findById(1)).thenReturn(Optional.of(task));
        Optional<Task> found = taskService.getTaskById(1);
        assertTrue(found.isPresent());
        assertEquals("Fix Bugs", found.get().getTitle());
    }
}
