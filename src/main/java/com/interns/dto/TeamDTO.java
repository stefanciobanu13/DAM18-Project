package com.interns.dto;

import lombok.Data;

import java.util.List;

@Data
public class TeamDTO {
    private Integer id;
    private String name;
    private Integer mentorId;
    private List<Integer> internIds;
}
