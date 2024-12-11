package com.interns.model.repository;

import com.interns.model.Intern;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InternRepository extends JpaRepository<Intern, Integer> {

    List<Intern> findByTeamId(Integer teamId);

}
