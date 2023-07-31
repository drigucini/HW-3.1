package ru.hogwarts.school.controller;

import ru.hogwarts.school.model.Faculty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.service.FacultyServiceImpl;

import java.util.Collection;

@RequestMapping("/faculty")
@RestController
public class FacultyController {
    private final FacultyServiceImpl service;

    public FacultyController(FacultyServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Faculty> createFaculty(@RequestBody Faculty faculty) {
        Faculty createdFaculty = service.createFaculty(faculty);
        return ResponseEntity.ok(createdFaculty);
    }

    @GetMapping("{facultyID}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable Long facultyID) {
        Faculty faculty = service.getFacultyByID(facultyID);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PutMapping()
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {
        Faculty updatedFaculty = service.updateFaculty(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping
    public void deleteFaculty(@RequestBody Long facultyID) {
        service.deleteFaculty(facultyID);
    }


@GetMapping
    public Collection<Faculty> getAllFaculty() {
        return service.getAllFaculty();
    }

    @GetMapping("/find")
    public Collection<Faculty> getAllByColor(@RequestParam String color) {
        return service.getAllByColor(color);
    }
}
