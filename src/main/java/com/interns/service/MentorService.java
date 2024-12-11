package com.interns.service;

import com.interns.model.Mentor;

import java.util.List;
import java.util.Optional;

public interface MentorService {

    Mentor saveMentor(Mentor mentor);

    Mentor updateMentor(Integer id, Mentor mentor);

    void deleteMentor(Integer id);

    Optional<Mentor> getMentorById(Integer id);

    List<Mentor> getAllMentors();
}
