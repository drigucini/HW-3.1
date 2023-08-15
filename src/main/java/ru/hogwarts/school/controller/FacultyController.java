package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RequestMapping("/faculty")
@RestController
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
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

    @GetMapping("/findByNameOrColor")
    public ResponseEntity<Collection<Faculty>> findByColorOrName(@RequestParam(required = false) String name,
                                                                 @RequestParam(required = false) String color) {
        Collection<Faculty> facultiesByColor = service.findByColorOrName(name, color);
        return ResponseEntity.ok(facultiesByColor);
    }

    @GetMapping("/{id}/students")
    public Collection<Student> getStudents(@PathVariable Long id) {
        return service.getStudents(id);
    }

    @PutMapping()
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty) {

        Faculty updatedFaculty = service.updateFaculty(faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("{id}")
    public void deleteFaculty(@PathVariable Long id) {
        service.deleteFaculty(id);
    }

    @GetMapping
    public Collection<Faculty> getAllFaculty() {
        return service.getAllFaculty();
    }
}
