package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        logger.info("createStudent method was invoked");
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentByID(Long studentID) {
        logger.info("getStudentByID method was invoked");
        return studentRepository.findById(studentID).orElseGet(()->{
            logger.warn("Student with id {} was not found", studentID);
            return null;
                }
        );
    }

    @Override
    public Student updateStudent(Student student) {
        logger.info("updateStudent method was invoked");
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentID) {
        logger.info("deleteStudent method was invoked");
        studentRepository.deleteById(studentID);
    }

    @Override
    public Collection<Student> getAll() {
        logger.info("getAll method was invoked");
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getAllByAge(int age) {
        logger.info("getAllByAge method was invoked");
        return getAll()
                .stream()
                .filter(it -> it.getAge() == age)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Student> findByAgeBetween(int min, int max){
        logger.info("findByAgeBetween method was invoked");
        return studentRepository.findAllByAgeBetweenOrderByAge(min, max);
    }

    @Override
    public Faculty getFacultyOfStudent(Long studentId) {
        logger.info("getFacultyOfStudent method was invoked");
        return studentRepository.findById(studentId)
                .map(Student::getFaculty)
                .orElse(null);
    }

    @Override
    public int countStudents() {
        logger.info("countStudents method was invoked");
        return studentRepository.countStudents();
    }

    @Override
    public int getAverageAgeOfStudents() {
        logger.info("getAverageAgeOfStudents method was invoked");
        return studentRepository.getAverageAgeOfStudents();
    }

    @Override
    public List<Student> getLast5StudentsOrderedById() {
        logger.info("getLast5StudentsOrderedById method was invoked");
        return studentRepository.getLast5StudentsOrderedById();
    }

}
