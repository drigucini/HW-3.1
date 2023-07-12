package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;

import java.util.Collection;

public interface FacultyService {
    Faculty createFaculty(Faculty faculty);
    Faculty getFacultyByID(Long facultyID);
    Faculty updateFaculty(Long facultyID, Faculty faculty);
    Faculty deleteFaculty(Long facultyID);
    Collection<Faculty> getAllFaculty();
    Collection<Faculty> getAllByColor(String color);
}
