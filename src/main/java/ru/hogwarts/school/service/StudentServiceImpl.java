package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long counter = 0L;

    @Override
    public Student createStudent(Student student) {
        student.setId(++counter);
        students.put(student.getId(), student);

        return students.get(student.getId());
    }

    @Override
    public Student getStudentByID(Long studentID) {
        return students.get(studentID);
    }

    @Override
    public Student updateStudent(Long studentID, Student student) {
        students.put(studentID, student);
        return student;
    }

    @Override
    public Student deleteStudent(Long studentID) {
        return students.remove(studentID);
    }

    @Override
    public Collection<Student> getAll() {
        return students.values();
    }

    @Override
    public Collection<Student> getAllByAge(int age) {
        return getAll()
                .stream()
                .filter(it -> it.getAge() == age)
                .collect(Collectors.toList());
    }

}
