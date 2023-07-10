package service;

import model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    private final Map<Long, Student> students = new HashMap<>();
    private Long generatedStudentID = 1L;

    public Student createStudent(Student student) {
        students.put(generatedStudentID, student);
        generatedStudentID++;
        return student;
    }

    public Student getStudentByID(Long studentID) {
        return students.get(studentID);
    }

    public Student updateStudent(Long studentID, Student student) {
        students.put(studentID, student);
        return student;
    }

    public Student deleteStudent(Long studentID) {
        return students.remove(studentID);
    }

    @Override
    public Collection<Student> getAll() {
        return students.values();
    }
}
