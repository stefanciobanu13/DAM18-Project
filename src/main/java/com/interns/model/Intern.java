package com.interns.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    @Entity
    public class Intern {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NotNull
        private String name;

        @Min(18)
        private int age;

        @NotNull
        @Email
        private String email;

        @NotNull
        @Pattern(regexp = "^[+]?[0-9]{10,15}$", message = "Invalid phone number format")
        private String phoneNumber;

        @NotNull
        @ManyToOne
        @JoinColumn(name = "team_id")
        private Team team;

        @OneToMany(mappedBy = "intern", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Task> tasks = new ArrayList<>();
    }

