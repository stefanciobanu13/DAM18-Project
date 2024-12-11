package com.interns.service;

import com.interns.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project saveProject(Project project);

    Project updateProject(Integer id, Project project);

    void deleteProject(Integer id);

    Optional<Project> getProjectById(Integer id);

    List<Project> getAllProjects();
}