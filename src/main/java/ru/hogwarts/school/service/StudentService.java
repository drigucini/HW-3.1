package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudentByID(Long studentID);
    Student updateStudent(Long studentID, Student student);
    Student deleteStudent(Long studentID);
    Collection<Student> getAll();
    Collection<Student> getAllByAge(int age);
}
