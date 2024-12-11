package com.interns.dto;

import lombok.Data;

import java.util.List;

@Data
public class MentorDTO {
    private Integer id;
    private String name;
    private String expertise;
    private List<Integer> teamIds;
}
