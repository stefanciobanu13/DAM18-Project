package com.interns.service.impl;

import com.interns.model.Project;
import com.interns.model.repository.ProjectRepository;
import com.interns.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Integer id, Project project) {
        return projectRepository.findById(id)
                .map(existingProject -> {
                    existingProject.setName(project.getName());
                    existingProject.setDescription(project.getDescription());
                    return projectRepository.save(existingProject);
                })
                .orElseThrow(() -> new IllegalArgumentException("Project with ID " + id + " not found."));
    }

    @Override
    public void deleteProject(Integer id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Project with ID " + id + " not found.");
        }
    }

    @Override
    public Optional<Project> getProjectById(Integer id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}
