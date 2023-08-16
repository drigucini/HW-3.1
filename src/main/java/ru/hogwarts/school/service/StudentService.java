package ru.hogwarts.school.service;

import org.springframework.web.bind.annotation.RequestParam;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentByID(Long studentID);
    Student updateStudent(Student student);
    void deleteStudent(Long studentID);
    Collection<Student> getAll();
    Collection<Student> getAllByAge(int age);
    Collection<Student> findByAgeBetween( int min, int max);
    Faculty getFacultyOfStudent (Long studentId);
    int countStudents();
    int getAverageAgeOfStudents();
    List<Student> getLast5StudentsOrderedById();

}
