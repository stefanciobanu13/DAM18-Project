package com.interns.dto.mappers;

import com.interns.dto.InternDTO;
import com.interns.model.Intern;

import java.util.stream.Collectors;

public class InternMapper {

    public static InternDTO toDTO(Intern intern) {
        InternDTO dto = new InternDTO();
        dto.setId(intern.getId());
        dto.setName(intern.getName());
        dto.setAge(intern.getAge());
        dto.setEmail(intern.getEmail());
        dto.setPhoneNumber(intern.getPhoneNumber());
        dto.setTeamId(intern.getTeam() != null ? intern.getTeam().getId() : null);
        dto.setTaskIds(intern.getTasks()
                .stream()
                .map(task -> task.getId())
                .collect(Collectors.toList()));
        return dto;
    }

    public static Intern toEntity(InternDTO dto) {
        Intern intern = new Intern();
        intern.setId(dto.getId());
        intern.setName(dto.getName());
        intern.setAge(dto.getAge());
        intern.setEmail(dto.getEmail());
        intern.setPhoneNumber(dto.getPhoneNumber());
        return intern;
    }
}
