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
@RequestMapping(value = "students")

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

@GetMapping("/age-range")
    public ResponseEntity<List<StudentReadDto>> getStudentsByAgeRange(
            @RequestParam int minAge,
            @RequestParam int maxAge
) {
    List<StudentReadDto> students = studentService.getStudentByAgeRange(minAge, maxAge);

    return ResponseEntity.ok(students);
}

@GetMapping("/{id}/house")
public ResponseEntity<HouseReadDto> getHouseOfStudent(
        @PathVariable Long id
) {
    ;
        HouseReadDto houseDto = studentService.getHouseOfStudent(id);
        return ResponseEntity.ok(houseDto);

}


@GetMapping("/age/{value}")
    public ResponseEntity<List<StudentReadDto>> getStudentsByAge(
            @PathVariable int value
    ) {
        List<StudentReadDto> arrayStudent = studentService.getStudentsByAge(value);


        return ResponseEntity.ok(arrayStudent);
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

