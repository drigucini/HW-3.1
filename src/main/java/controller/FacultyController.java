package controller;

import model.Faculty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FacultyServiceImpl;

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
        Faculty updatedFaculty = service.updateFaculty(faculty.getId(), faculty);
        return ResponseEntity.ok(updatedFaculty);
    }

    @PutMapping()
    public ResponseEntity<Faculty> deleteFaculty(@RequestBody Long facultyID) {
        Faculty deletedFaculty = service.deleteFaculty(facultyID);
        return ResponseEntity.ok(deletedFaculty);
    }
}
