package ru.hogwarts.school.mappers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;
import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.model.Student;

//@Component
//public class StudentMapper {
//    public  StudentDto mapToDto(Student student) {
//        StudentDto dto = new StudentDto();
//        dto.setId(student.getId());
//        dto.setName(student.getName());
//        dto.setAge(student.getAge());
//
//        dto.setHouse(HouseMapper.convertToHouseDTO(student.getHouse()));
//
//        return dto;
//    }
//
//    public  Student mapToStudent(StudentDto dto) {
//        Student student = new Student();
//        student.setId(dto.getId());
//        student.setName(dto.getName());
//        student.setAge(dto.getAge());
//        student.setHouse(HouseMapper.convertToHouse(dto.getHouse()));
//
//        return student;
//    }
//}
