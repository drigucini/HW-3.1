package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findAllByAgeBetweenOrderByAge(int min, int max);
    Collection<Student> findAllByFaculty_Id(Long id);

    @Query(value = "select count(*) from student", nativeQuery = true)
    int countStudents();

    @Query(value = "select avg(age) from student", nativeQuery = true)
    int getAverageAgeOfStudents();

    @Query(value = "select * from student order by id desc limit 5", nativeQuery = true)
    List<Student> getLast5StudentsOrderedById();
}
