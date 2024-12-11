package com.interns.dto.mappers;

import com.interns.dto.TaskDTO;
import com.interns.model.Task;

public class TaskMapper {

    public static TaskDTO toDTO(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setInternId(task.getIntern() != null ? task.getIntern().getId() : null);
        dto.setProjectId(task.getProject() != null ? task.getProject().getId() : null);
        return dto;
    }

    public static Task toEntity(TaskDTO dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        return task;
    }
}
