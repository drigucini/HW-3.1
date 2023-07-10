package service;

import model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentByID(Long studentID);
    Student updateStudent(Long studentID, Student student);
    Student deleteStudent(Long studentID);
    Collection<Student> getAll();
}
