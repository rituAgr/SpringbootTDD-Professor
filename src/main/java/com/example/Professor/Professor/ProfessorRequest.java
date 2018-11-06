package com.example.Professor.Professor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorRequest {

    @NotEmpty
    //@Pattern(regexp = "^[(a-zA-Z]{3}[^a-zA-Z0-9]{1}[0-9]{3}")
    String id;

    //@Length(min = 1,max = 5)
    @Size(min = 1,max = 5)
    String name;

    @Min(2)
    @Max(5)
    int NumberClassesPerCourse;

//    @Override
//    public String toString(){
//        return "id : "+getId()+", name : "+getName()+", NumberClassesPerCourse : "+ getNumberClassesPerCourse();
//    }

}
