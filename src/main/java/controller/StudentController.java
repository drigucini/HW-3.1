package controller;

import model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.StudentService;
import service.StudentServiceImpl;

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
        Student updatedStudent = service.updateStudent(student.getId(), student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Student deletedStudent = service.deleteStudent(id);
        return ResponseEntity.ok(deletedStudent);
    }



//    @PutMapping()
//    public Collection<Object> getStudentsByAge (@RequestBody Long age) {
//        HashSet<Student> studentsByAge = new ArrayList<>(List.of(Student));
//
//        return studentsByAge;
//    }
}
