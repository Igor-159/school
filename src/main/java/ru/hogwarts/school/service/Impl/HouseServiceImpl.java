package ru.hogwarts.school.service.Impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.House;
import ru.hogwarts.school.repository.HouseRepository;
import ru.hogwarts.school.service.HouseService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class HouseServiceImpl  implements HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }
    public List<House> getAllHouse() {

        List<House> result = houseRepository.findAll();
        log.info("getAllHouse");
        return result;
    }

   public House createHouse(House house) {
       House newHouse = houseRepository.save(house);
       log.info("createHouse");
       return newHouse;


    }

    public Optional<House> getHouse(Long id) {
        return houseRepository.findById(id);
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
