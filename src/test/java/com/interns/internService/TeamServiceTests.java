package com.interns.internService;

import com.interns.model.Team;
import com.interns.model.Mentor;
import com.interns.model.repository.TeamRepository;
import com.interns.service.impl.TeamServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TeamServiceTests {

    @Mock
    private TeamRepository teamRepository;

    @InjectMocks
    private TeamServiceImpl teamService;

    private Team team;
    private Mentor mentor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mentor = new Mentor();
        mentor.setId(1);
        mentor.setName("John Mentor");

        team = new Team();
        team.setId(1);
        team.setName("Team Alpha");
        team.setMentor(mentor);
    }

    @Test
    void testSaveTeam() {
        when(teamRepository.save(team)).thenReturn(team);
        Team savedTeam = teamService.saveTeam(team);
        assertNotNull(savedTeam);
        assertEquals("Team Alpha", savedTeam.getName());
    }

    @Test
    void testGetTeamById() {
        when(teamRepository.findById(1)).thenReturn(Optional.of(team));
        Optional<Team> foundTeam = teamService.getTeamById(1);
        assertTrue(foundTeam.isPresent());
        assertEquals("Team Alpha", foundTeam.get().getName());
    }

    @Test
    void testGetAllTeams() {
        when(teamRepository.findAll()).thenReturn(List.of(team));
        List<Team> teams = teamService.getAllTeams();
        assertEquals(1, teams.size());
    }

    @Test
    void testUpdateTeam() {
        when(teamRepository.findById(1)).thenReturn(Optional.of(team));
        Team updatedTeam = new Team();
        updatedTeam.setName("Team Beta");
        updatedTeam.setMentor(mentor);

        when(teamRepository.save(any(Team.class))).thenReturn(updatedTeam);
        Team result = teamService.updateTeam(1, updatedTeam);
        assertEquals("Team Beta", result.getName());
    }

    @Test
    void testDeleteTeam() {
        when(teamRepository.existsById(1)).thenReturn(true);
        teamService.deleteTeam(1);
        verify(teamRepository, times(1)).deleteById(1);
    }
}
