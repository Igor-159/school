package ru.hogwarts.school.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.hogwarts.school.annotation.IT;
import ru.hogwarts.school.dto.StudentReadDto;
import org.assertj.core.api.Assertions;

import java.util.List;

@IT

public class StudentServiceIT {

    @Autowired
    private final StudentService studentService;

    public StudentServiceIT(StudentService studentService) {
        this.studentService = studentService;
    }

    @Test
    void getAllStudents() {
        List<StudentReadDto> resultList = studentService.getAllStudents();
        Assertions.assertThat(resultList).hasSize(3);
    }
}
