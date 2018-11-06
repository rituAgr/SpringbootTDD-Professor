package com.example.Professor.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@RestController
@Validated
public class ProfessorController {

    ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService){
        this.professorService=professorService;
    }

    @PostMapping("api/professor")//, consumes = "application/json")
    public void addProfessor(@Valid @RequestBody ProfessorRequest professorRequest) throws MethodArgumentNotValidException{//}, IncorrectDataFormatException {
        professorService.add(professorRequest);
    }

    @GetMapping("api/professor/{id}")
    public ProfessorRequest getProfessor(@Valid @Pattern(regexp = "^[(a-zA-Z]{3}[^a-zA-Z0-9]{1}[0-9]{3}")  @PathVariable String id){
        return professorService.get(id);
    }
}
