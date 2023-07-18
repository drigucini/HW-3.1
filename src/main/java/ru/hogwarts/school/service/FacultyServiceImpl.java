package ru.hogwarts.school.service;
import ru.hogwarts.school.model.Faculty;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService{
    private final Map<Long, Faculty> facultyList = new HashMap<>();
    private Long generatedFacultyID = 0L;

    @Override
    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++generatedFacultyID);
        facultyList.put(faculty.getId(), faculty);
        return facultyList.get(faculty.getId());
    }

    @Override
    public Faculty getFacultyByID(Long facultyID) {
        return facultyList.get(facultyID);
    }

    @Override
    public Faculty updateFaculty(Long facultyID, Faculty faculty) {
        facultyList.put(facultyID, faculty);
        return faculty;
    }

    @Override
    public Faculty deleteFaculty(Long facultyID) {
        return facultyList.remove(facultyID);
    }

    @Override
    public Collection<Faculty> getAllFaculty() {
        return facultyList.values();
    }

    @Override
    public Collection<Faculty> getAllByColor(String color) {
        return getAllFaculty()
                .stream()
                .filter(it -> it.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
