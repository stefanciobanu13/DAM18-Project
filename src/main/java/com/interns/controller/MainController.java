package com.interns.controller;

import com.interns.model.*;
import com.interns.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    private final MentorService mentorService;
    private final ProjectService projectService;
    private final TaskService taskService;
    private final TeamService teamService;
    private final InternService internService;

    @Autowired
    public MainController(MentorService mentorService, ProjectService projectService,
                          TaskService taskService, TeamService teamService, InternService internService) {
        this.mentorService = mentorService;
        this.projectService = projectService;
        this.taskService = taskService;
        this.teamService = teamService;
        this.internService = internService;
    }

    @PostMapping("/interns")
    public ResponseEntity<Intern> createIntern(@RequestBody Intern intern) {
        Intern savedIntern = internService.saveIntern(intern);
        return ResponseEntity.status(201).body(savedIntern);
    }

    @GetMapping("/interns/{id}")
    public ResponseEntity<Intern> getInternById(@PathVariable Integer id) {
        Optional<Intern> intern = internService.getInternById(id);
        return intern.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/interns")
    public ResponseEntity<List<Intern>> getAllInterns() {
        List<Intern> interns = internService.getAllInterns();
        return ResponseEntity.ok(interns);
    }

    @PutMapping("/interns/{id}")
    public ResponseEntity<Intern> updateIntern(@PathVariable Integer id, @RequestBody Intern intern) {
        Intern updatedIntern = internService.updateIntern(id, intern);
        return ResponseEntity.ok(updatedIntern);
    }

    @DeleteMapping("/interns/{id}")
    public ResponseEntity<Void> deleteIntern(@PathVariable Integer id) {
        internService.deleteIntern(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/mentors")
    public ResponseEntity<Mentor> createMentor(@RequestBody Mentor mentor) {
        return ResponseEntity.ok(mentorService.saveMentor(mentor));
    }

    @GetMapping("/mentors/{id}")
    public ResponseEntity<Mentor> getMentor(@PathVariable Integer id) {
        Optional<Mentor> mentor = mentorService.getMentorById(id);
        return mentor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/mentors/{id}")
    public ResponseEntity<Mentor> updateMentor(@PathVariable Integer id, @RequestBody Mentor mentor) {
        return ResponseEntity.ok(mentorService.updateMentor(id, mentor));
    }

    @DeleteMapping("/mentors/{id}")
    public ResponseEntity<Void> deleteMentor(@PathVariable Integer id) {
        mentorService.deleteMentor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mentors")
    public ResponseEntity<List<Mentor>> getAllMentors() {
        return ResponseEntity.ok(mentorService.getAllMentors());
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.saveProject(project));
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Integer id) {
        Optional<Project> project = projectService.getProjectById(id);
        return project.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Integer id, @RequestBody Project project) {
        return ResponseEntity.ok(projectService.updateProject(id, project));
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Integer id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Integer id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping("/teams")
    public ResponseEntity<Team> createTeam(@RequestBody Team team) {
        return ResponseEntity.ok(teamService.saveTeam(team));
    }

    @GetMapping("/teams/{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Integer id) {
        Optional<Team> team = teamService.getTeamById(id);
        return team.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/teams/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Integer id, @RequestBody Team team) {
        return ResponseEntity.ok(teamService.updateTeam(id, team));
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Integer id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }
}

