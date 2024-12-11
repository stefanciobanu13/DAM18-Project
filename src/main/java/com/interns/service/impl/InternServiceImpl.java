package com.interns.service.impl;

import com.interns.model.Intern;
import com.interns.model.repository.InternRepository;
import com.interns.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternServiceImpl implements InternService {

    private final InternRepository internRepository;

    @Autowired
    public InternServiceImpl(InternRepository internRepository) {
        this.internRepository = internRepository;
    }

    @Override
    public Intern saveIntern(Intern intern) {
        return internRepository.save(intern);
    }

    @Override
    public Intern updateIntern(Integer id, Intern intern) {

        Optional<Intern> existingIntern = internRepository.findById(id);
        if (existingIntern.isPresent()) {

            Intern updatedIntern = existingIntern.get();
            updatedIntern.setName(intern.getName());
            updatedIntern.setEmail(intern.getEmail());
            updatedIntern.setPhoneNumber(intern.getPhoneNumber());
            updatedIntern.setTeam(intern.getTeam());
            return internRepository.save(updatedIntern);
        } else {
            throw new IllegalArgumentException("Intern with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteIntern(Integer id) {
        if (internRepository.existsById(id)) {
            internRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Intern with ID " + id + " not found.");
        }
    }

    @Override
    public Optional<Intern> getInternById(Integer id) {

        return internRepository.findById(id);
    }

    @Override
    public List<Intern> getAllInterns() {

        return internRepository.findAll();
    }

    @Override
    public List<Intern> getInternsByTeamId(Integer teamId) {

        return internRepository.findByTeamId(teamId);
    }
}
