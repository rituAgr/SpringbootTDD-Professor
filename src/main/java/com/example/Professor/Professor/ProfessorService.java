package com.example.Professor.Professor;

import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    public void add(ProfessorRequest professorRequest) {
        return;
    }

    public ProfessorRequest get(String id) {
        return new ProfessorRequest(id, "Peter", 5);
    }
}
