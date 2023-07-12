package ru.hogwarts.school.service;

import ru.hogwarts.school.model.Faculty;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyServiceImpl {
    private final Map<Long, Faculty> facultyList = new HashMap<>();
    private Long generatedFacultyID = 1L;

    public Faculty createFaculty(Faculty faculty) {
        facultyList.put(generatedFacultyID, faculty);
        generatedFacultyID++;
        return faculty;
    }

    public Faculty getFacultyByID(Long facultyID) {
        return facultyList.get(facultyID);
    }

    public Faculty updateFaculty(Long facultyID, Faculty faculty) {
        facultyList.put(facultyID, faculty);
        return faculty;
    }

    public Faculty deleteFaculty(Long facultyID) {
        return facultyList.remove(facultyID);
    }
}
