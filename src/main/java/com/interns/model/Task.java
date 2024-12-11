package com.interns.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
    @Entity
    public class Task {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @NotNull
        private String title;

        private String description;

        @Enumerated(EnumType.STRING)
        private TaskStatus status;

        @NotNull
        @ManyToOne
        @JoinColumn(name = "intern_id")
        private Intern intern;

        @ManyToOne
        @JoinColumn(name = "project_id")
        private Project project;
    }

