package ru.hogwarts.school.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.school.dto.HouseReadDto;
import ru.hogwarts.school.dto.StudentCreateEditDto;
import ru.hogwarts.school.dto.StudentReadDto;
import ru.hogwarts.school.service.Impl.StudentServiceImpl;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@Tag(name = "student controller")
@RestController
@RequestMapping(value = "students")

public class StudentController {
    private final StudentService studentService;

public StudentController(StudentServiceImpl studentService) {
    this.studentService = studentService;
}

@GetMapping("/{id}")
    public StudentReadDto getStudentBuId(
            @PathVariable Long id
) {
    return studentService.getStudent(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
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
    public StudentReadDto createStudent(
        @RequestBody StudentCreateEditDto studentDto
) {
    return studentService.createStudent(studentDto);

}

@PutMapping
    public StudentReadDto updateStudent(
        @PathVariable Long id,
        @RequestBody StudentCreateEditDto dto
) {

    return studentService.updateStudent(id, dto)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));


}

@DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(
            @PathVariable Long id
) {
        studentService.deleteStudent(id);

        return  ResponseEntity.noContent().build();
}
}

