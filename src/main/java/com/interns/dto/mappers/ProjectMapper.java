package com.interns.dto.mappers;

import com.interns.dto.ProjectDTO;
import com.interns.model.Project;

import java.util.stream.Collectors;

public class ProjectMapper {

    public static ProjectDTO toDTO(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setTaskIds(project.getTasks()
                .stream()
                .map(task -> task.getId())
                .collect(Collectors.toList()));
        return dto;
    }

    public static Project toEntity(ProjectDTO dto) {
        Project project = new Project();
        project.setId(dto.getId());
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        return project;
    }
}
