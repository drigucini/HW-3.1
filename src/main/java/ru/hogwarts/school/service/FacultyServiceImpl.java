package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.FacultyRepository;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService {
    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;
    private Logger logger = LoggerFactory.getLogger(FacultyServiceImpl.class);

    public FacultyServiceImpl(FacultyRepository facultyRepository, StudentRepository studentRepository) {
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;

    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        logger.info("createFaculty method was invoked");
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFacultyByID(Long facultyID) {
        logger.info("getFacultyByID method was invoked");
        return facultyRepository.findById(facultyID).orElse(null);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        logger.info("updateFaculty method was invoked");
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(Long facultyID) {
        logger.info("deleteFaculty method was invoked");
        facultyRepository.deleteById(facultyID);
    }

    @Override
    public Collection<Faculty> getAllFaculty() {
        logger.info("getAllFaculty method was invoked");
        return facultyRepository.findAll();
    }

    @Override
    public Collection<Faculty> findByColorOrName(String color, String name) {
        logger.info("findByColorOrName method was invoked");
        return facultyRepository.findFacultiesByNameOrColorIgnoreCase(color, name);
    }

    @Override
    public Collection<Student> getStudents(Long id) {
        logger.info("getStudents method was invoked");
        return studentRepository.findAllByFaculty_Id(id);
    }
}
