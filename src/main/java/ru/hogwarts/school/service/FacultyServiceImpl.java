package ru.hogwarts.school.service;
import ru.hogwarts.school.model.Faculty;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl implements FacultyService{
private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty getFacultyByID(Long facultyID) {
        return facultyRepository.findById(facultyID).orElse(null);
    }

    @Override
    public Faculty updateFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(Long facultyID) {
         facultyRepository.deleteById(facultyID);
    }

    @Override
    public Collection<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public Collection<Faculty> getAllByColor(String color) {
        return getAllFaculty()
                .stream()
                .filter(it -> it.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
