package com.interns.service;

import com.interns.model.Intern;

import java.util.List;
import java.util.Optional;

public interface InternService {

    Intern saveIntern(Intern intern);

    Intern updateIntern(Integer id, Intern intern);

    void deleteIntern(Integer id);

    Optional<Intern> getInternById(Integer id);

    List<Intern> getAllInterns();

    List<Intern> getInternsByTeamId(Integer teamId);
}