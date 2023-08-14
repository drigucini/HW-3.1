package ru.hogwarts.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private StudentService studentService;

    @Test
    void shouldCreateStudent() throws Exception {
        //given
        Student student = new Student();
        student.setId(1L);
        student.setName("Ron Wisley");
        student.setAge(25);

        when(studentService.createStudent(student)).thenReturn(student);

        //when
        ResultActions resultActions = mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(objectMapper.writeValueAsString(student))
        );


        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(student.getName()))
                .andExpect(jsonPath("$.age").value(student.getAge()))
                .andExpect(jsonPath("$.id").value(student.getId()));
    }

    @Test
    void shouldReturnListOfStudents() throws Exception {
        //given
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student(1L, "Harry", 18),
                        new Student(2L, "Hermione", 23),
                        new Student(3L, "Ron", 42)
                )
        );

        when(studentService.getAll()).thenReturn(students);

        //when
        ResultActions resultActions = mockMvc.perform(get("/students"));

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(students.size()))
                .andDo(print());
    }

}
