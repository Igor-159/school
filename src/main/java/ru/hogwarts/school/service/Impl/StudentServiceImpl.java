package ru.hogwarts.school.service.Impl;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.hogwarts.school.dto.HouseReadDto;
import ru.hogwarts.school.dto.StudentCreateEditDto;

import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.dto.StudentReadDto;
import ru.hogwarts.school.mappers.HouseReadMapper;
import ru.hogwarts.school.mappers.StudentCreateEditMapper;

import ru.hogwarts.school.mappers.StudentReadMapper;
import ru.hogwarts.school.model.House;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.StudentService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentReadMapper studentReadMapper;
    private final StudentCreateEditMapper studentCreateEditMapper;
    private final HouseReadMapper houseReadMapper;


    @Transactional
    public StudentReadDto createStudent(StudentCreateEditDto studentDto) {
        return Optional.of(studentDto)
                .map(studentCreateEditMapper::map)
                .map(studentRepository::save)
                .map(studentReadMapper::map)
                .orElseThrow();
    }

    public HouseReadDto getHouseOfStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        House house = student.get().getHouse();
        log.info("getHouseByStudent");
        return Optional.of(house)
                .map(houseReadMapper::map)
                .orElseThrow();

    }

    public Optional<StudentReadDto> getStudent(Long id) {
        log.info("getStudent");
        return studentRepository.findById(id)
                .map(studentReadMapper::map);
    }

    public List<StudentReadDto> getAllStudents() {
        log.info("getAllStudents");
        return studentRepository.findAll().stream()
                .map(studentReadMapper::map)
                .toList();
    }

    public List<StudentReadDto> getStudentsByAge(int age) {
        return studentRepository.findStudentByAge(age).stream()
                .map(studentReadMapper::map)
                .toList();
    }

    public List<StudentReadDto> getStudentByAgeRange(int minAge, int maxAge) {
        log.info("getStudentByAgeRange");
        return studentRepository.findAllByAgeBetween(minAge, maxAge).stream()
                .map(studentReadMapper::map)
                .toList();
    }

    public Integer getNumberOfStudents() {
        log.info("getNumberOfStudents");
        return studentRepository.getNumberOfStudents();
    }

    public Double getAverageAge() {
        log.info("getAverageAge");
        return studentRepository.getAverageAge();
    }

    @Transactional
    public Optional<StudentReadDto> updateStudent(Long id, StudentCreateEditDto studentDto) {

        return studentRepository.findById(id)
                .map(entity -> studentCreateEditMapper.map(studentDto, entity))
                .map(studentRepository::saveAndFlush)
                .map(studentReadMapper::map);

    }

    @Transactional
    public boolean deleteStudent(Long id) {
        log.info("deleteStudent");
        return studentRepository.findById(id)
                .map(entity -> {
                    studentRepository.delete(entity);
//                    studentRepository.flush();
                    return true;
                })
                .orElse(false);

    }

}
