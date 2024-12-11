package com.interns.dto;

import lombok.Data;

import java.util.List;

@Data
public class InternDTO {
    private Integer id;
    private String name;
    private int age;
    private String email;
    private String phoneNumber;
    private Integer teamId;
    private List<Integer> taskIds;
}
