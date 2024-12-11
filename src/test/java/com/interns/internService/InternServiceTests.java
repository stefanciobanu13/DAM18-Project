package com.interns.internService;

import com.interns.model.Intern;
import com.interns.model.Team;
import com.interns.model.repository.InternRepository;
import com.interns.service.impl.InternServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InternServiceTests {

    @Mock
    private InternRepository internRepository;

    @InjectMocks
    private InternServiceImpl internService;

    private Intern intern;
    private Team team;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        team = new Team();
        team.setId(1);
        team.setName("Development");

        intern = new Intern();
        intern.setId(1);
        intern.setName("John Doe");
        intern.setTeam(team);
    }

    @Test
    void testSaveIntern() {
        when(internRepository.save(intern)).thenReturn(intern);
        Intern savedIntern = internService.saveIntern(intern);
        assertNotNull(savedIntern);
        assertEquals("John Doe", savedIntern.getName());
    }

    @Test
    void testGetInternById() {
        when(internRepository.findById(1)).thenReturn(Optional.of(intern));
        Optional<Intern> found = internService.getInternById(1);
        assertTrue(found.isPresent());
        assertEquals("John Doe", found.get().getName());
    }

    @Test
    void testGetAllInterns() {
        when(internRepository.findAll()).thenReturn(List.of(intern));
        List<Intern> interns = internService.getAllInterns();
        assertEquals(1, interns.size());
    }

    @Test
    void testDeleteIntern() {
        when(internRepository.existsById(1)).thenReturn(true);
        internService.deleteIntern(1);
        verify(internRepository, times(1)).deleteById(1);
    }
}
