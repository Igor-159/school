package ru.hogwarts.school.service;


import ru.hogwarts.school.dto.HouseReadDto;
import ru.hogwarts.school.dto.StudentCreateEditDto;
import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.dto.StudentReadDto;
import ru.hogwarts.school.model.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {
    public StudentReadDto createStudent(StudentCreateEditDto student);

    public Optional<StudentReadDto> getStudent(Long id);

    public List<StudentReadDto> getStudentByAgeRange(int minAge, int maxAge);
    public List<StudentReadDto> getStudentsByAge(int age);

    public List<StudentReadDto> getAllStudents();

    public Integer getNumberOfStudents();

    public Double getAverageAge();
    public HouseReadDto getHouseOfStudent(Long id);

    public Optional<StudentReadDto> updateStudent(Long id, StudentCreateEditDto dto);

    public boolean deleteStudent(Long id);


}
