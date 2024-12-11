package com.interns.service.impl;

import com.interns.model.Mentor;
import com.interns.model.repository.MentorRepository;
import com.interns.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService {

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorServiceImpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public Mentor saveMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public Mentor updateMentor(Integer id, Mentor mentor) {
        return mentorRepository.findById(id)
                .map(existingMentor -> {
                    existingMentor.setName(mentor.getName());
                    existingMentor.setExpertise(mentor.getExpertise());
                    return mentorRepository.save(existingMentor);
                })
                .orElseThrow(() -> new IllegalArgumentException("Mentor with ID " + id + " not found."));
    }

    @Override
    public void deleteMentor(Integer id) {
        if (mentorRepository.existsById(id)) {
            mentorRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Mentor with ID " + id + " not found.");
        }
    }

    @Override
    public Optional<Mentor> getMentorById(Integer id) {
        return mentorRepository.findById(id);
    }

    @Override
    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }
}