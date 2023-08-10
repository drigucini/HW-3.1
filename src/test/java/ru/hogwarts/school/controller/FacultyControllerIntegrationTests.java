package ru.hogwarts.school.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FacultyControllerIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private FacultyRepository facultyRepository;

    @AfterEach
    public void resetOb() {
        facultyRepository.deleteAll();
    }

    @Test
    void shouldCreateFaculty() {
        //given
        Faculty faculty = new Faculty();
        faculty.setName("Gryffindor");
        faculty.setColor("red");

        //when
        ResponseEntity<Faculty> response = restTemplate.postForEntity("/faculty", faculty, Faculty.class);

        //then
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody()).isNotNull();
        Assertions.assertThat(response.getBody().getId()).isNotNull();
        Assertions.assertThat(response.getBody().getName()).isNotNull();
        Assertions.assertThat(response.getBody().getColor()).isNotNull();
    }

    @Test
    void shouldGetFaculty() {
        //given
        Long facultyId = persistTestFaculty("Gryffindor", "Red").getId();

        //when
        ResponseEntity<Faculty> responseEntity = restTemplate.getForEntity("/faculty/{facultyId}", Faculty.class, facultyId);

        //then
        Faculty faculty = responseEntity.getBody();
        Assertions.assertThat(faculty).isNotNull();
        Assertions.assertThat(faculty.getId()).isEqualTo(facultyId);
    }

    private Faculty persistTestFaculty(String name, String color) {
        Faculty faculty = new Faculty(name, color);
        return facultyRepository.save(faculty);
    }

}
