package ru.hogwarts.school.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.hogwarts.school.annotation.IT;
import ru.hogwarts.school.dto.StudentCreateEditDto;
import ru.hogwarts.school.dto.StudentReadDto;
import ru.hogwarts.school.service.StudentService;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@IT

public class StudentServiceIT {

    private final static Long STUDENT_2 = 2l;
    private final static Long HOUSE_1 = 1l;
    private final StudentService studentService;
    public StudentServiceIT(StudentService studentService) {
        this.studentService = studentService;
    }

    @Test
    void getAllStudents() {
        List<StudentReadDto> resultList = studentService.getAllStudents();
        assertThat(resultList).hasSize(3);
    }

    @Test
    void getStudent () {
        Optional<StudentReadDto> maybeStudent = studentService.getStudent(STUDENT_2);
        assertTrue(maybeStudent.isPresent());
        maybeStudent.ifPresent(student -> assertEquals("pasha", student.getName()));
    }

    @Test
    void create() {
        StudentCreateEditDto studentDto = new StudentCreateEditDto(
                "bmx",
                35,
                HOUSE_1,
                null
        );
        StudentReadDto actualResult = studentService.createStudent(studentDto);

        assertEquals(studentDto.getName(), actualResult.getName());
        assertEquals(studentDto.getAge(), actualResult.getAge());
        assertEquals(studentDto.getHouseId(), actualResult.getHouse().id());
        assertEquals(studentDto.getAvatarId(), actualResult.getAvatar().id());
    }

    @Test

    void updateStudent() {
        StudentCreateEditDto studentDto = new StudentCreateEditDto(
                "test",
                35,
                HOUSE_1,
                null
        );
        Optional<StudentReadDto> actualResult = studentService.updateStudent(STUDENT_2, studentDto);

        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(student -> {
            assertEquals(studentDto.getName(), student.getName());
            assertEquals(studentDto.getAge(), student.getAge());
            assertEquals(studentDto.getHouseId(), student.getHouse().id());
            assertEquals(studentDto.getAvatarId(), student.getAvatar().id());
        });
    }

    @Test
    void delete() {
        assertFalse(studentService.deleteStudent(124l));
        assertTrue(studentService.deleteStudent(STUDENT_2));
    }
}
