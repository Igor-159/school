package ru.hogwarts.school.service;


import ru.hogwarts.school.dto.HouseReadDto;
import ru.hogwarts.school.dto.StudentReadDto;
import ru.hogwarts.school.model.House;
import java.util.List;
import java.util.Optional;

public interface HouseService {
    public List<HouseReadDto> getAllHouse();

    public House createHouse(House house);

    public Optional<HouseReadDto> getHouse(Long id);

    public House updateHouse(Long id, String newColor);

    public House deleteHouse(Long id);

    public List<House> getHousesByColor(String color);

}
