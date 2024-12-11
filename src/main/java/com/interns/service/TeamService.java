package com.interns.service;

import com.interns.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {

    Team saveTeam(Team team);

    Team updateTeam(Integer id, Team team);

    void deleteTeam(Integer id);

    Optional<Team> getTeamById(Integer id);

    List<Team> getAllTeams();
}
