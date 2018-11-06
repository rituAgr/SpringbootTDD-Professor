package com.example.Professor.Professor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.constraints.Null;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@RunWith(SpringRunner.class)
@WebMvcTest(ProfessorController.class)
public class ProfessorControllerTest {

    @MockBean
    private ProfessorService professorService;

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    private JacksonTester<ProfessorRequest> jsonTester;

    @Before
    public void setUp(){
        JacksonTester.initFields(this,objectMapper);
    }


    //POST
    //body is empty or null
    //id is empty - how can we check this
    //wrong format post
    //correct

    //TODO : Resolve the following empty id request
    @Test
    public void postProfessor_IdisEmpty() throws Exception {
        ProfessorRequest professorRequest = new ProfessorRequest("azs@125","Prof1",4);
        String profJson =jsonTester.write(professorRequest).getJson();
        //profJson=profJson.replaceAll("\"aBs@125\"","\"\"");
        //when(professorService.add(professorRequest).doNothing();
        //mvc.perform(post("api/professor").contentType(MediaType.APPLICATION_JSON).
                //.andExpect(status().isBadRequest());
        mvc.perform(post("api/professor").contentType(MediaType.APPLICATION_JSON).content(profJson)).andExpect(status().isBadRequest());

    }

    @Test
    public void postProfessor_RequestBodyisNull() throws Exception{
        ProfessorRequest professorRequest = new ProfessorRequest();
        String requestJson = jsonTester.write(professorRequest).getJson();
//        mvc.perform(post("/api/professor").contentType(MediaType.APPLICATION_JSON).(requestJson))
//                .andExpect(status().isBadRequest());
    }

    //TODO: Resolve datatype check
    @Test
    public void postProfessor_wrongFormatRequest() throws Exception{
        ProfessorRequest professorRequest = new ProfessorRequest("aBs!125","Prof",4);
        //String requestBody=professorRequest.toString();
        String requestBody =jsonTester.write(professorRequest).getJson();
        //mvc.perform(MockMvcRequestBuilders.post("api/professor").contentType(MediaType.APPLICATION_JSON).(requestBody).contentEquals())
                //.andExpect(status().isBadRequest());
    }

    //TODO: Resolve success check
    @Test
    public void postProfessor_success() throws Exception {
        ProfessorRequest professorRequest = new ProfessorRequest("Abn*124","Name",3);
        String jsonProf = jsonTester.write(professorRequest).getJson();
        mvc.perform(post("api/professor").contentType(MediaType.APPLICATION_JSON).content(jsonProf))
                        .andExpect(status().isOk());
    }

//GET
    //id is null,
    //id is wrog format
    //data not found in db
    //+ case

    @Test
    public void getProfessor_success() throws Exception {
        ProfessorRequest professorRequest = new ProfessorRequest();
        professorRequest.setName("Name");
        professorRequest.setNumberClassesPerCourse(4);
        professorRequest.setId("abD!901");

        String jsonProf = jsonTester.write(professorRequest).getJson();
        mvc.perform(get("api/professor/{id}","abD!901"))
                .andExpect(status().isBadRequest());

    }
}