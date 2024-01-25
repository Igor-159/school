package ru.hogwarts.school.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.HouseReadDto;
import ru.hogwarts.school.dto.StudentCreateEditDto;
import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.dto.StudentReadDto;
import ru.hogwarts.school.model.House;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.Impl.StudentServiceImpl;
import ru.hogwarts.school.service.StudentService;

import java.util.List;
import java.util.Optional;

@Tag(name = "student controller")
@RestController
@RequestMapping(value = "student")

public class StudentController {
    private final StudentService studentService;

public StudentController(StudentServiceImpl studentService) {
    this.studentService = studentService;
}

@GetMapping("/{id}")
    public ResponseEntity<StudentReadDto> getStudentBuId(
            @PathVariable Long id
) {
    Optional<StudentReadDto> student = studentService.getStudent(id);

        if(student.isPresent()){
            return  ResponseEntity.ok(student.get());
        }
        return ResponseEntity.notFound().build();
}

//@GetMapping("/age-range")
//    public ResponseEntity<List<StudentDto>> getStudentsByAgeRange(
//            @RequestParam int minAge,
//            @RequestParam int maxAge
//) {
//    List<Student> students = studentService.getStudentByAgeRange(minAge, maxAge);
//    List<StudentDto> studentsDto = students.stream()
//            .map(student -> StudentMapper.convertToDTO(student))
//            .toList();
//    return ResponseEntity.ok(studentsDto);
//}

//@GetMapping("/{id}/house")
//public ResponseEntity<HouseReadDto> getStudentHouse(
//        @PathVariable Long id
//) {
//    Optional<Student> student = studentService.getStudent(id);
//    if(student.isPresent()) {
//        House house = student.get().getHouse();
//        HouseReadDto houseDto = HouseMapper.convertToHouseDTO(house);
//        return ResponseEntity.ok(houseDto);
//    }else{
//        return ResponseEntity.notFound().build();
//    }
//}


@GetMapping("/age/{value}")
    public ResponseEntity<List<StudentReadDto>> getStudentsByAge(
            @PathVariable int value
    ) {
        List<StudentReadDto> arrayStudent = studentService.getStudentsByAge(value);
        List<StudentDto> studentsDto = arrayStudent.stream()
                                            .map(student -> StudentMapper.convertToDTO(student))
                                            .toList();

        return ResponseEntity.ok(studentsDto);
}

@GetMapping
    public ResponseEntity<List<StudentReadDto>> getAllStudents() {
    List<StudentReadDto> resultList = studentService.getAllStudents();
    return ResponseEntity.ok(resultList);
}

@GetMapping("/number_of_students")
    public ResponseEntity<Integer> getNumberOfStudents() {
    Integer numberOfStudents = studentService.getNumberOfStudents();
    return ResponseEntity.ok(numberOfStudents);
}

@GetMapping("/average_age")
    public ResponseEntity<Double> getAverageAge() {
        Double averageAge = studentService.getAverageAge();
        return ResponseEntity.ok(averageAge);
    }




@PostMapping
    public ResponseEntity<StudentReadDto> createStudent(
        @RequestBody StudentCreateEditDto studentDto
) {
    StudentReadDto student = studentService.createStudent(studentDto);
    return  ResponseEntity.ok(student);
}

@PutMapping
    public ResponseEntity<StudentReadDto> updateStudent(
        @PathVariable Long id,
        @RequestBody StudentCreateEditDto dto
) {

    Optional<StudentReadDto> updatedStudent = studentService.updateStudent(id, dto);

    return  ResponseEntity.ok(updatedStudent.get());
}

@DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(
            @PathVariable Long id
) {
        studentService.deleteStudent(id);

        return  ResponseEntity.noContent().build();
}
}

