package com.interns.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectDTO {
    private Integer id;
    private String name;
    private String description;
    private List<Integer> taskIds;
}
