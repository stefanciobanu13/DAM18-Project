package com.interns.dto;

import com.interns.model.TaskStatus;
import lombok.Data;

@Data
public class TaskDTO {
    private Integer id;
    private String title;
    private String description;
    private TaskStatus status;
    private Integer internId;
    private Integer projectId;
}
