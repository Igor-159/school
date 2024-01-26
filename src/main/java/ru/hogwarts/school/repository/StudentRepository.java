package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school.dto.StudentReadDto;
import ru.hogwarts.school.model.House;
import ru.hogwarts.school.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByAge(int age);
    List<Student> findAllByAgeBetween(int minAge, int maxAge);

    @Query("SELECT COUNT(*) FROM Student s")
    Integer getNumberOfStudents();

    @Query("SELECT AVG(s.age) FROM Student s")
    Double getAverageAge();

}
