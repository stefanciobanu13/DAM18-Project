package com.interns.dto.mappers;

import com.interns.dto.MentorDTO;
import com.interns.model.Mentor;

import java.util.stream.Collectors;

public class MentorMapper {

    public static MentorDTO toDTO(Mentor mentor) {
        MentorDTO dto = new MentorDTO();
        dto.setId(mentor.getId());
        dto.setName(mentor.getName());
        dto.setExpertise(mentor.getExpertise());
        dto.setTeamIds(mentor.getTeams()
                .stream()
                .map(team -> team.getId())
                .collect(Collectors.toList()));
        return dto;
    }

    public static Mentor toEntity(MentorDTO dto) {
        Mentor mentor = new Mentor();
        mentor.setId(dto.getId());
        mentor.setName(dto.getName());
        mentor.setExpertise(dto.getExpertise());
        return mentor;
    }
}
