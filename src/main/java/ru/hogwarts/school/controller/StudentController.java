package ru.hogwarts.school.controller;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;
import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {
   private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public Collection<Student> findAll() {
        return service.getAll();
    }

    @GetMapping("/findByAgeBetween")
    public Collection<Student> findByAgeBetween(@RequestParam int min, @RequestParam int max) {
        return service.findByAgeBetween(min, max);
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {

        Student createdStudent = service.createStudent(student);
        return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("{studentID}")
    public ResponseEntity<Student> getStudentByID(@PathVariable Long studentID) {
        Student student = service.getStudentByID(studentID);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = service.updateStudent(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }



    @GetMapping("/find")
    public Collection<Student> getAllByAge (@RequestParam int age) {
        return service.getAllByAge(age);
    }

    @GetMapping("{id}/faculty")
    public Faculty getFacultyOfStudent(@PathVariable Long id) {
        return service.getFacultyOfStudent(id);
    }
}
