package com.interns.dto.mappers;

import com.interns.dto.TeamDTO;
import com.interns.model.Team;

import java.util.stream.Collectors;

public class TeamMapper {

    public static TeamDTO toDTO(Team team) {
        TeamDTO dto = new TeamDTO();
        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setMentorId(team.getMentor() != null ? team.getMentor().getId() : null);
        dto.setInternIds(team.getInterns()
                .stream()
                .map(intern -> intern.getId())
                .collect(Collectors.toList()));
        return dto;
    }

    public static Team toEntity(TeamDTO dto) {
        Team team = new Team();
        team.setId(dto.getId());
        team.setName(dto.getName());
        return team;
    }
}
