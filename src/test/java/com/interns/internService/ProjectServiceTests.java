package com.interns.internService;

import com.interns.model.Project;
import com.interns.model.repository.ProjectRepository;
import com.interns.service.impl.ProjectServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ProjectServiceTests {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private Project project;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        project = new Project();
        project.setId(1);
        project.setName("Project X");
        project.setDescription("Top secret project");
    }

    @Test
    void testSaveProject() {
        when(projectRepository.save(project)).thenReturn(project);
        Project savedProject = projectService.saveProject(project);
        assertNotNull(savedProject);
        assertEquals("Project X", savedProject.getName());
    }

    @Test
    void testGetProjectById() {
        when(projectRepository.findById(1)).thenReturn(Optional.of(project));
        Optional<Project> foundProject = projectService.getProjectById(1);
        assertTrue(foundProject.isPresent());
        assertEquals("Project X", foundProject.get().getName());
    }

    @Test
    void testGetAllProjects() {
        when(projectRepository.findAll()).thenReturn(List.of(project));
        List<Project> projects = projectService.getAllProjects();
        assertEquals(1, projects.size());
    }

    @Test
    void testUpdateProject() {
        when(projectRepository.findById(1)).thenReturn(Optional.of(project));
        Project updatedProject = new Project();
        updatedProject.setName("Project Y");
        updatedProject.setDescription("Updated project description");

        when(projectRepository.save(any(Project.class))).thenReturn(updatedProject);
        Project result = projectService.updateProject(1, updatedProject);
        assertEquals("Project Y", result.getName());
        assertEquals("Updated project description", result.getDescription());
    }

    @Test
    void testDeleteProject() {
        when(projectRepository.existsById(1)).thenReturn(true);
        projectService.deleteProject(1);
        verify(projectRepository, times(1)).deleteById(1);
    }
}
