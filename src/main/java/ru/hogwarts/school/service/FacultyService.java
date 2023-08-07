package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);
    Faculty getFacultyByID(Long facultyID);
    Faculty updateFaculty(Faculty faculty);
    void deleteFaculty(Long facultyID);
    Collection<Faculty> getAllFaculty();
    Collection<Faculty> getAllByColor(String color);
    Faculty findByColorOrName(String color, String name);
    Collection<Student> getStudents (Long id);
}
