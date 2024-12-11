package com.interns.service.impl;

import com.interns.model.Team;
import com.interns.model.repository.TeamRepository;
import com.interns.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team saveTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Integer id, Team team) {
        return teamRepository.findById(id)
                .map(existingTeam -> {
                    existingTeam.setName(team.getName());
                    existingTeam.setMentor(team.getMentor());
                    return teamRepository.save(existingTeam);
                })
                .orElseThrow(() -> new IllegalArgumentException("Team with ID " + id + " not found."));
    }

    @Override
    public void deleteTeam(Integer id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Team with ID " + id + " not found.");
        }
    }

    @Override
    public Optional<Team> getTeamById(Integer id) {
        return teamRepository.findById(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
