package com.interns.internService;

import com.interns.model.Mentor;
import com.interns.model.repository.MentorRepository;
import com.interns.service.impl.MentorServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MentorServiceTests {

    @Mock
    private MentorRepository mentorRepository;

    @InjectMocks
    private MentorServiceImpl mentorService;

    private Mentor mentor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mentor = new Mentor();
        mentor.setId(1);
        mentor.setName("Alice Smith");
        mentor.setExpertise("Java");
    }

    @Test
    void testSaveMentor() {
        when(mentorRepository.save(mentor)).thenReturn(mentor);
        Mentor savedMentor = mentorService.saveMentor(mentor);
        assertNotNull(savedMentor);
        assertEquals("Alice Smith", savedMentor.getName());
    }

    @Test
    void testGetAllMentors() {
        when(mentorRepository.findAll()).thenReturn(List.of(mentor));
        List<Mentor> mentors = mentorService.getAllMentors();
        assertEquals(1, mentors.size());
    }
}

