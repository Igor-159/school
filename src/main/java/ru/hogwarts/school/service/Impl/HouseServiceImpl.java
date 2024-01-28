package ru.hogwarts.school.service.Impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.hogwarts.school.dto.HouseReadDto;
import ru.hogwarts.school.dto.StudentReadDto;
import ru.hogwarts.school.mappers.HouseReadMapper;
import ru.hogwarts.school.model.House;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.HouseRepository;
import ru.hogwarts.school.service.HouseService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class HouseServiceImpl  implements HouseService {

    private final HouseRepository houseRepository;
    private final HouseReadMapper houseReadMapper;


    public List<HouseReadDto> getAllHouse() {

        List<HouseReadDto> result = houseRepository.findAll().stream()
                .map(houseReadMapper::map)
                .toList();
        log.info("getAllHouse");
        return result;
    }

   public House createHouse(House house) {
       House newHouse = houseRepository.save(house);
       log.info("createHouse");
       return newHouse;


    }

    public Optional<HouseReadDto> getHouse(Long id) {

        return houseRepository.findById(id)
                .map(houseReadMapper::map);
    }

    @Transactional
    public House updateHouse(Long id, String newColor) {
        Optional<House> houseToUpdate = houseRepository.findById(id);
        log.info("updateHouse");
        if(houseToUpdate.isPresent()) {
            House house = houseToUpdate.get();
            house.setColor(newColor);
            return houseRepository.save(house);
        }
        return null;

    }

    public House deleteHouse(Long id) {
        House house = houseRepository.getReferenceById(id);
        houseRepository.delete(house);
        log.info("deleteHouse");
        return house;
    }

    public List<House> getHousesByColor(String color) {
        log.info("getHousesByColor");
        return houseRepository.findByColor(color);
    }


}
