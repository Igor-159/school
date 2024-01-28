package ru.hogwarts.school.controllers;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.school.dto.HouseReadDto;
import ru.hogwarts.school.exception.HouseNotFoundException;
import ru.hogwarts.school.model.House;
import ru.hogwarts.school.service.HouseService;
import ru.hogwarts.school.service.Impl.HouseServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/house")

public class HouseController {

    private final HouseService houseService;

    public HouseController (HouseServiceImpl houseService) {
        this.houseService = houseService;
    }

    @GetMapping
    public ResponseEntity<List<HouseReadDto>> getAllHouse() {
        var resultList = houseService.getAllHouse();
        return ResponseEntity.ok(resultList);
    }

    @GetMapping("/{id}")
    public HouseReadDto getHouseBuId(@PathVariable Long id) {

        return  houseService.getHouse(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));;
    }

//    @GetMapping("/{id}/student")
//    public ResponseEntity<List<Student>> getStudentByHouse(
//            @PathVariable Long id
//    ) {
//        student
//        Optional<House> house = houseService.getHouse(id);
//
//        if(house.isPresent()) {
//            List<Student> students = house.get().getStudents();
//            return ResponseEntity.ok(students);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }

    @Transactional
    @PostMapping
    public ResponseEntity<House> createHouse(
            @RequestBody House house

    ) {
        House newHouse = houseService.createHouse(house);
        return   ResponseEntity.ok(newHouse);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<House> updateHouse(
            @PathVariable Long id,
            @RequestBody House house
    )   {
        House newHouse = houseService.updateHouse(id, house.getColor());
        return  ResponseEntity.ok(newHouse);
    }

    @DeleteMapping("/{id}")
    public void deleteHouse(@PathVariable Long id){
        House house = houseService.getHouse(id).orElseThrow(() -> new HouseNotFoundException("User id " + id + " was not found"));
        houseService.deleteHouse(house.getId());

    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<House>> getHouseByColor(
            @PathVariable String color
    ) {
        List<House> arrayHouse = houseService.getHousesByColor(color);
        return new ResponseEntity<>(arrayHouse, HttpStatus.OK);
    }
}
